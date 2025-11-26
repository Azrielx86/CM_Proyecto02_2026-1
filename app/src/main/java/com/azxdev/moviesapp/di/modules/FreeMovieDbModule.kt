package com.azxdev.moviesapp.di.modules

import com.azxdev.moviesapp.Constants
import com.azxdev.moviesapp.services.MoviesDbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class FreeMovieDbModule {
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesFreeMovieDbService(retrofit: Retrofit): MoviesDbService {
        return retrofit.create(MoviesDbService::class.java)
    }
}