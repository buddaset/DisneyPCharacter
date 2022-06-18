package com.example.disneyperson.disney_characters.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disneyperson.disney_characters.data.local.model.DisneyCharacterEntity


@Database(entities = [DisneyCharacterEntity::class], version = 1, exportSchema = false)
abstract class DisneyCharacterDatabase : RoomDatabase() {

    abstract fun disneyCharactersDao(): DisneyCharactersDao





}