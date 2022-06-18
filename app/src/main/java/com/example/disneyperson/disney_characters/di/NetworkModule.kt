package com.example.disneyperson.disney_characters.di

import com.example.disneyperson.disney_characters.data.repositories.DisneyCharactersRepositoryImpl
import com.example.disneyperson.disney_characters.data.remote.DisneyCharacterDataSource
import com.example.disneyperson.disney_characters.data.remote.DisneyService
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository
import com.example.disneyperson.disney_characters.domain.usecase.GetDisneyCharactersUseCase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

class NetworkModule {

    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()


    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val disneyService: DisneyService by lazy { retrofit.create() }








    companion object {

        private const val BASE_URL = "http://api.disneyapi.dev"
        private const val DB_NAME = "CharactersDatabase"


    }


}