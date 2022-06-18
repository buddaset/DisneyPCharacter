package com.example.disneyperson.disney_characters.domain.repository

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter
import kotlinx.coroutines.flow.Flow

interface DisneyCharactersRepository {

     fun disneyCharacters(): Flow<List<DisneyCharacter>>

    suspend fun updateData()

}