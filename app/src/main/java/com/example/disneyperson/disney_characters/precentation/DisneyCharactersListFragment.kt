package com.example.disneyperson.disney_characters.precentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneyperson.App
import com.example.disneyperson.core.HandleState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.disneyperson.core.onError
import com.example.disneyperson.core.onLoading
import com.example.disneyperson.core.onSuccess
import com.example.disneyperson.databinding.FragmentDisneyCharactersBinding
import com.example.disneyperson.disney_characters.precentation.adapter.DisneyAdapter
import com.example.disneyperson.disney_characters.precentation.model.DisneyCharacterUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DisneyCharactersFragment : Fragment() {

    private lateinit var binding: FragmentDisneyCharactersBinding

    private val disneyAdapter by lazy { DisneyAdapter() }

    private val viewModel: DisneyCharacterViewModel by viewModels {
        DisneyViewModelFactory(
            (activity?.application as App).useCase,
            (activity?.application as App).updateCase
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDisneyCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        observeData()
    }

    private fun observeData() {
        collectFlow(viewModel.characters) { state ->
            state
                .onSuccess { updateData(it) }
                .onError { showToast(it) }
                .onLoading { loading() }
        }
    }


    private fun loading() {}

    private fun showToast(ex: Throwable) {
        Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
    }

    private fun updateData(data: DisneyCharacterUI) =
        disneyAdapter.setData(data.characters)

    private fun setupAdapter() = with(binding) {
        numbers.layoutManager = LinearLayoutManager(context)
        numbers.setHasFixedSize(true)
        numbers.adapter = disneyAdapter

    }

    companion object {


        fun newInstance() = DisneyCharactersFragment()
    }
}


fun <T> Fragment.collectFlow(flow: Flow<T>, onCollect: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest {
                onCollect(it)
            }
        }
    }

}




