package com.example.disneyperson.disney_characters.domain.repository

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter

interface DisneyCharactersRepository {

    suspend fun disneyCharacters(): HandleState<List<DisneyCharacter>>
}