package com.example.disneyperson.disney_characters.data.local

import com.example.disneyperson.core.runHandling
import com.example.disneyperson.disney_characters.data.local.model.DisneyCharacterEntity
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    suspend fun save(characters: List<DisneyCharacterEntity>)

    fun read() : Flow<List<DisneyCharacterEntity>>

}


class CharactersDataSource(
    private val dao: DisneyCharactersDao
) : LocalDataSource {


   override suspend fun save(characters: List<DisneyCharacterEntity>) {
        dao.saveDisneyCharacters(characters)
    }

   override fun read() : Flow<List<DisneyCharacterEntity>> =
     dao.getDisneyCharacters()


}