package com.example.disneyperson.disney_characters.domain.usecase

import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository

class UpdateDisneyCharactersUseCase(
  private val repository: DisneyCharactersRepository
) {


   suspend fun execute() {
        repository.updateData()
    }
}