package com.azxdev.moviesapp.data.repositories

import com.azxdev.moviesapp.data.remote.model.MovieDetails
import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import com.azxdev.moviesapp.services.MoviesDbService
import javax.inject.Inject

class MoviesDbRepository @Inject constructor(
    private val moviesDbService: MoviesDbService
) {
    suspend fun searchMovie(query: String): MoviesDbSearchResponse {
        return moviesDbService.searchMovie(query)
    }

    suspend fun getMovieDetails(id: String): MovieDetails {
        return moviesDbService.getMovieDetails(id)
    }
}