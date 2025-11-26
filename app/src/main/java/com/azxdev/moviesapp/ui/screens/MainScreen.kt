package com.azxdev.moviesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import com.azxdev.moviesapp.viewmodels.MainScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()
) {
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember {
        mutableStateOf(MoviesDbSearchResponse(true, arrayListOf(), 0))
    }

    suspend fun performSearch() {
        if (searchQuery.isEmpty())
            return
        searchResults = viewModel.searchMovie(searchQuery)
    }

    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotBlank()) {
            delay(500L)
            performSearch()
        } else {
            searchResults = MoviesDbSearchResponse(true, arrayListOf(), 0)
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(searchResults.movieResult) { movie ->
                Text(text = movie.title, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
