package com.example.disneyperson.disney_characters.data.remote.model

import com.example.disneyperson.disney_characters.data.local.model.DisneyCharacterEntity
import com.example.disneyperson.disney_characters.domain.models.DisneyCharacter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DisneyCharacterDto(
    @SerialName("_id")
    val id: Int,
    val name: String,
    val imageUrl: String
)

fun DisneyCharacterDto.toDomainModel() : DisneyCharacter =
    DisneyCharacter(id, name , imageUrl)


fun DisneyCharacterDto.toEntity(): DisneyCharacterEntity =
    DisneyCharacterEntity(id, name, imageUrl)

fun List<DisneyCharacterDto>.toListEntity() : List<DisneyCharacterEntity> =
    this.map { it.toEntity() }