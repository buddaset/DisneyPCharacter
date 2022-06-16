package com.example.disneyperson.list_persons.domain

interface DisneyCharactersRepository {

    suspend fun disneyCharacters(): List<DisneyPersonDomain>
}