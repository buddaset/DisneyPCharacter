package com.example.disneyperson.disney_characters.data.local.model

import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter

class DisneyCharacterEntity(
    val id: Int,
    val name: String,
    val imageUrl: String
)


fun DisneyCharacterEntity.toDomainModel(): DisneyCharacter =
    DisneyCharacter(id = id, name = name , imageUrl = imageUrl)
