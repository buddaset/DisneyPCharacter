package com.example.disneyperson.disney_characters.domain.usecase

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository

class GetDisneyCharactersUseCase(private val repository: DisneyCharactersRepository) {


    suspend fun execute(): HandleState<List<DisneyCharacter>> =
        repository.disneyCharacters()


}



