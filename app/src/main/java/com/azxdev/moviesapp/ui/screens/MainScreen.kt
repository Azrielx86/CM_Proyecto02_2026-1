package com.azxdev.moviesapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.azxdev.moviesapp.R
import com.azxdev.moviesapp.data.remote.model.MoviesDbSearchResponse
import com.azxdev.moviesapp.navigation.ScreenDestination
import com.azxdev.moviesapp.ui.components.MovieResultCard
import com.azxdev.moviesapp.viewmodels.MainScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()
) {
    var searchQuery by remember { mutableStateOf("Maid dragon") }
    var searchResults by remember {
        mutableStateOf<MoviesDbSearchResponse?>(null)
    }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    suspend fun performSearch() {
        if (searchQuery.length < 3) {
            isError = true
            errorMessage = context.getString(R.string.search_validation_error)
            return
        }

        isLoading = true
        errorMessage = null
        isError = false

        try {
            searchResults = viewModel.searchMovie(searchQuery)
        } catch (_: Exception) {
            errorMessage = context.getString(R.string.generic_error)
        } finally {
            isLoading = false
        }
    }

    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotBlank()) {
            delay(500L)
            performSearch()
        } else {
            searchResults = null
            errorMessage = null
            isError = false
        }
    }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        if (it.length >= 3) {
                            isError = false
                            errorMessage = null
                        }
                    },
                    label = { Text(stringResource(R.string.search)) },
                    modifier = Modifier.fillMaxWidth(),
                    isError = isError
                )
                if (isError) {
                    Text(
                        text = errorMessage ?: "",
                        modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                    )
                }
            }

            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (errorMessage != null && !isError) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = errorMessage!!)
                }
            } else if (searchResults?.movieDetailShorts?.isEmpty() == true) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = stringResource(id = R.string.no_results))
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    searchResults?.movieDetailShorts?.let { details ->
                        items(details) { movie ->
                            MovieResultCard(
                                id = movie.imdbId,
                                title = movie.title,
                                year = movie.year,
                                rank = movie.rank,
                                image = movie.imgPoster,
                                onClick = {
                                    navController.navigate(
                                        ScreenDestination.MovieDetailsScreenDestination(
                                            movieId = it
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}