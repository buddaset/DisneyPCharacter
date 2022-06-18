package com.example.disneyperson.disney_characters.data.local

import androidx.room.*
import com.example.disneyperson.disney_characters.data.local.model.DisneyCharacterEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DisneyCharactersDao {

    @Query("SELECT * FROM characters")
    fun getDisneyCharacters(): Flow<List<DisneyCharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDisneyCharacters(characters: List<DisneyCharacterEntity>)

    @Query("DELETE FROM characters")
    suspend fun deleteAll()

    @Transaction
    suspend fun deleteAllAndUpdate(characters: List<DisneyCharacterEntity>) {
        deleteAll()
        saveDisneyCharacters(characters)
    }
}