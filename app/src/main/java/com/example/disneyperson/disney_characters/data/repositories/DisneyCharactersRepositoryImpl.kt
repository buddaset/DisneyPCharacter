package com.example.disneyperson.disney_characters.data.repositories

import com.example.disneyperson.core.*
import com.example.disneyperson.disney_characters.data.local.DisneyCharactersDao
import com.example.disneyperson.disney_characters.data.local.LocalDataSource
import com.example.disneyperson.disney_characters.data.local.model.toDomain
import com.example.disneyperson.disney_characters.data.local.model.toDomainModel

import com.example.disneyperson.disney_characters.data.remote.RemoteDataSource
import com.example.disneyperson.disney_characters.data.remote.model.toDomainModel
import com.example.disneyperson.disney_characters.data.remote.model.toListEntity
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.runCatching

class DisneyCharactersRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DisneyCharactersRepository {

    override fun disneyCharacters(): Flow<List<DisneyCharacter>> =
        localDataSource.read()
            .map { it.toDomain() }
            .flowOn(Dispatchers.IO)


    override suspend fun updateData(): Unit = withContext(Dispatchers.IO) {
        remoteDataSource.getCharacters().onSuccess { localDataSource.save(it.toListEntity()) }
    }


}






