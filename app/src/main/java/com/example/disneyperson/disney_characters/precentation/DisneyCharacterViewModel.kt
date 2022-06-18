package com.example.disneyperson.disney_characters.precentation

import androidx.lifecycle.*
import com.example.disneyperson.core.HandleState
import com.example.disneyperson.core.transform
import com.example.disneyperson.disney_characters.domain.usecase.GetDisneyCharactersUseCase
import com.example.disneyperson.disney_characters.domain.usecase.UpdateDisneyCharactersUseCase
import com.example.disneyperson.disney_characters.precentation.model.DisneyCharacterUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DisneyCharacterViewModel(
    private val getDisneyCharactersUseCase: GetDisneyCharactersUseCase,
    private val updateDisneyCharactersUseCase: UpdateDisneyCharactersUseCase
) : ViewModel() {


    private val _characters: MutableStateFlow<HandleState<DisneyCharacterUI>> =
        MutableStateFlow(HandleState.Loading())
    val characters: StateFlow<HandleState<DisneyCharacterUI>> = _characters

    init {
        viewModelScope.launch {
            updateData()
            getCharacters()
        }
    }

    private suspend fun updateData() = updateDisneyCharactersUseCase.execute()

    private suspend fun getCharacters() {
        getDisneyCharactersUseCase.execute()
            .catch { e ->
                _characters.value = HandleState.Error(e)
            }
            .collect { data ->
                _characters.value = HandleState.Success(DisneyCharacterUI(characters = data))
            }
    }


}


class DisneyViewModelFactory(
    private val getDisneyCharactersUseCase: GetDisneyCharactersUseCase,
    private val updateDisneyCharactersUseCase: UpdateDisneyCharactersUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DisneyCharacterViewModel(
            getDisneyCharactersUseCase,
            updateDisneyCharactersUseCase
        ) as T
    }

}