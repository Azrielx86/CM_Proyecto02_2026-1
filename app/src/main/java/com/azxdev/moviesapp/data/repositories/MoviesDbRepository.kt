package com.azxdev.moviesapp.data.repositories

import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import com.azxdev.moviesapp.services.MoviesDbService
import javax.inject.Inject

class MoviesDbRepository @Inject constructor(
    private val moviesDbService: MoviesDbService
) {
    suspend fun searchMovie(query: String): MoviesDbSearchResponse {
        return moviesDbService.searchMovie(query)
    }
}