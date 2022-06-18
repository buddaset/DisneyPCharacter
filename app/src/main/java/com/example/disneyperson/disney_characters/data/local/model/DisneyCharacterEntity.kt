package com.example.disneyperson.disney_characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter

@Entity(tableName = "characters")
class DisneyCharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String
)


fun DisneyCharacterEntity.toDomainModel(): DisneyCharacter =
    DisneyCharacter(id = id, name = name , imageUrl = imageUrl)

fun List<DisneyCharacterEntity>.toDomain() : List<DisneyCharacter> =
    this.map { it.toDomainModel() }
