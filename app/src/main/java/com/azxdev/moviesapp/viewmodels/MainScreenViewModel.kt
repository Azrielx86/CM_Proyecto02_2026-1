package com.azxdev.moviesapp.viewmodels

import androidx.lifecycle.ViewModel
import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import com.azxdev.moviesapp.data.repositories.MoviesDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val moviesDbRepository: MoviesDbRepository
) : ViewModel() {
    suspend fun searchMovie(query: String): MoviesDbSearchResponse {
        return moviesDbRepository.searchMovie(query)
    }
}