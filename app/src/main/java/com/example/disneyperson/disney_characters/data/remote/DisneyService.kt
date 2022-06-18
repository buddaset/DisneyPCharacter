package com.example.disneyperson.disney_characters.data.remote


import com.example.disneyperson.disney_characters.data.remote.response.CharactersResponse
import retrofit2.http.GET

interface DisneyService {

    @GET("/characters?page=2")
    suspend fun getCharacters(): CharactersResponse
}