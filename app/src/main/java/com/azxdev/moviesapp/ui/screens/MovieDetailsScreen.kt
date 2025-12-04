package com.azxdev.moviesapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.azxdev.moviesapp.Constants
import com.azxdev.moviesapp.R
import com.azxdev.moviesapp.navigation.ScreenDestination
import com.azxdev.moviesapp.viewmodels.MovieDetailsViewModel

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val movieDetails by viewModel.movieDetails.collectAsState()
    val uriHandler = LocalUriHandler.current

    if (movieDetails == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        val details = movieDetails!!.short
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        details.name?.let {
                            Text(it)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_button_description)
                            )
                        }
                    },
                )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                item {
                    AsyncImage(
                        model = details.image,
                        contentDescription = details.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        details.name?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        movieDetails!!.top.releaseDate.let { releaseDate ->
                            Text(
                                text = stringResource(
                                    R.string.release_date,
                                    releaseDate
                                ), style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(
                                        ScreenDestination.TrailerScreenDestination(
                                            "${Constants.BASE_URL}/media/${movieDetails!!.imdbId}"
                                        )
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(stringResource(R.string.watch_trailer))
                            }
                            OutlinedButton(
                                onClick = { uriHandler.openUri("https://www.imdb.com/title/${movieDetails!!.imdbId}") },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(stringResource(R.string.go_to_imdb))
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        details.aggregateRating?.let {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = stringResource(R.string.rating),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text(
                                            text = "${it.ratingValue}/10",
                                            style = MaterialTheme.typography.headlineSmall.copy(
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                        movieDetails!!.main.ratingsSummary.let { ratingsSummary ->
                                            if (ratingsSummary?.topRanking != null) {
                                                Text(
                                                    text = stringResource(
                                                        R.string.imdb_rank,
                                                        "${ratingsSummary.topRanking.rank}",
                                                        ratingsSummary.topRanking.text.value
                                                    ),
                                                    style = MaterialTheme.typography.bodySmall
                                                )
                                            }
                                        }
                                        Text(
                                            text = stringResource(
                                                R.string.based_on_x_reviews,
                                                it.ratingCount
                                            ),
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.genres),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            details.genre.forEach { genre ->
                                SuggestionChip(
                                    onClick = { /* No-op */ },
                                    label = { Text(genre) }
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        details.description?.let {
                            Text(
                                text = stringResource(R.string.description),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        Text(
                            text = stringResource(R.string.cast),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            movieDetails!!.main.castV2.firstOrNull()?.credits?.let { castList ->
                                items(castList) { castMember ->
                                    Column(
                                        horizontalAlignment = CenterHorizontally,
                                        modifier = Modifier.width(80.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(80.dp)
                                                .clip(RoundedCornerShape(8.dp)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            val errorPainter =
                                                rememberVectorPainter(image = Icons.Default.Face)
                                            AsyncImage(
                                                model = castMember.name.primaryImage?.url,
                                                contentDescription = castMember.name.nameText?.text,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.fillMaxSize(),
                                                error = errorPainter
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        castMember.name.nameText?.text.let {
                                            if (it != null) {
                                                Text(
                                                    it,
                                                    style = MaterialTheme.typography.bodySmall,
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        details.contentRating?.let {
                            Text(
                                text = stringResource(R.string.content_rating),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        movieDetails!!.main.akas.let { aka ->
                            Text(
                                text = stringResource(R.string.akas),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            aka.edges.forEach { edge ->
                                Text(
                                    text = "- ${edge?.node?.text}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        details.review.let { review ->
                            if (review == null) return@let
                            Text(
                                text = stringResource(R.string.review),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = review.name,
                                        style = MaterialTheme.typography.titleSmall.copy(
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = stringResource(
                                            R.string.review_by,
                                            review.author.name
                                        ),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = review.reviewBody,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
