package com.example.disneyperson.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.example.disneyperson.R
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.github.johnnysc.coremvvm.sl.ProvideViewModel

class MainActivity : AppCompatActivity(), ProvideViewModel {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun <T : androidx.lifecycle.ViewModel> provideViewModel(
        clazz: Class<T>,
        owner: ViewModelStoreOwner
    ): T {
        TODO("Not yet implemented")
    }
}