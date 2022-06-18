package com.example.disneyperson

import android.app.Application
import androidx.room.Room
import com.example.disneyperson.disney_characters.data.local.CharactersDataSource
import com.example.disneyperson.disney_characters.data.repositories.DisneyCharactersRepositoryImpl
import com.example.disneyperson.disney_characters.data.local.DisneyCharacterDatabase
import com.example.disneyperson.disney_characters.data.local.LocalDataSource
import com.example.disneyperson.disney_characters.data.remote.DisneyCharacterDataSource
import com.example.disneyperson.disney_characters.di.NetworkModule
import com.example.disneyperson.disney_characters.domain.repository.DisneyCharactersRepository
import com.example.disneyperson.disney_characters.domain.usecase.GetDisneyCharactersUseCase
import com.example.disneyperson.disney_characters.domain.usecase.UpdateDisneyCharactersUseCase

class App : Application() {

    lateinit var useCase: GetDisneyCharactersUseCase
    lateinit var updateCase: UpdateDisneyCharactersUseCase

    override fun onCreate() {
        super.onCreate()

        val db: DisneyCharacterDatabase =   Room.databaseBuilder(
            this.applicationContext, DisneyCharacterDatabase::class.java, "db_character"
        ).build()


        val networkModule = NetworkModule()
        val service = networkModule.disneyService
        val remoteDataSource = DisneyCharacterDataSource(service)
        val localDataSource: LocalDataSource = CharactersDataSource(db.disneyCharactersDao())
        val disneyRepository: DisneyCharactersRepository =
            DisneyCharactersRepositoryImpl(remoteDataSource, localDataSource)
        useCase = GetDisneyCharactersUseCase(disneyRepository)
        updateCase = UpdateDisneyCharactersUseCase(disneyRepository)






    }


}



