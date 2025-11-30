package com.azxdev.moviesapp.services

import com.azxdev.moviesapp.data.remote.model.MovieDetails
import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDbService {
    @GET("search")
    suspend fun searchMovie(
        @Query("q")
        q: String
    ): MoviesDbSearchResponse

    @GET("search")
    suspend fun getMovieDetails(
        @Query("tt")
        tt: String
    ): MovieDetails

    @GET("media")
    suspend fun getMovieTrailer()
}