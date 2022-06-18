package com.example.disneyperson.disney_characters.data.remote.response


import com.example.disneyperson.disney_characters.data.remote.model.DisneyCharacterDto
import kotlinx.serialization.Serializable


@Serializable
data class CharactersResponse(
    val data: List<DisneyCharacterDto>
)
