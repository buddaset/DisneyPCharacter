package com.example.disneyperson.disney_characters.data.remote

import com.example.disneyperson.disney_characters.data.remote.model.DisneyCharacterResponse
import com.github.johnnysc.coremvvm.data.CloudDataSource
import com.github.johnnysc.coremvvm.data.HandleError

interface DisneyCharactersRemoteDataSource : RemoteDataSource {

    suspend fun latestDisneyCharacters(): List<DisneyCharacterResponse>

    class Base(
        private val disneyService: DisneyService,
        handleError: HandleError
    ) : CloudDataSource.Abstract(handleError), DisneyCharactersRemoteDataSource {

        override suspend fun latestDisneyCharacters(): List<DisneyCharacterResponse> = handle {
            disneyService.getCharacters().data
        }
    }
}


