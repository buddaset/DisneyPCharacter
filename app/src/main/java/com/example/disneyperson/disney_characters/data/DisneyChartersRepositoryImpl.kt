package com.example.disneyperson.disney_characters.data

import com.example.disneyperson.core.HandleState
import com.example.disneyperson.core.onSuccess
import com.example.disneyperson.core.transform
import com.example.disneyperson.disney_characters.data.remote.RemoteDataSource
import com.example.disneyperson.disney_characters.data.remote.model.toDomainModel
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter

class DisneyChartersRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : DisneyCharactersRepository {


    override suspend fun disneyCharacters(): HandleState<List<DisneyCharacter>> =
        remoteDataSource.getCharacters().transform { listGto ->
            listGto.map { it.toDomainModel() }
        }

}






