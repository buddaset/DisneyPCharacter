package com.example.disneyperson.disney_characters.domain.usecase

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository
import kotlinx.coroutines.flow.Flow

class GetDisneyCharactersUseCase(private val repository: DisneyCharactersRepository) {


     fun execute(): Flow<List<DisneyCharacter>> =
         repository.disneyCharacters()




}



