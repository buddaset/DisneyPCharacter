package com.example.disneyperson.disney_characters.data.remote

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.core.runHandling
import com.example.disneyperson.disney_characters.data.remote.model.DisneyCharacterDto

interface RemoteDataSource {

    suspend fun getCharacters(): HandleState<List<DisneyCharacterDto>>
}

class DisneyCharacterDataSource(
    private val disneyService: DisneyService
) : RemoteDataSource {

    override suspend fun getCharacters(): HandleState<List<DisneyCharacterDto>> = runHandling {
        disneyService.getCharacters().data
    }
}





