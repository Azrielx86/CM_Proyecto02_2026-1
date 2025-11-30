package com.azxdev.moviesapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azxdev.moviesapp.data.remote.model.MovieDetails
import com.azxdev.moviesapp.data.repositories.MoviesDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesDbRepository: MoviesDbRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails

    init {
        val movieId = savedStateHandle.get<String>("movieId")
        if (movieId != null) {
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(id: String) {
        viewModelScope.launch {
            try {
                _movieDetails.value = moviesDbRepository.getMovieDetails(id)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
