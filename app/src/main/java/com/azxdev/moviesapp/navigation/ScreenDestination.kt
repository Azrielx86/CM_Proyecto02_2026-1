package com.azxdev.moviesapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenDestination {

    @Serializable
    object HomeScreenDestination : ScreenDestination

    @Serializable
    data class MovieDetailsScreenDestination(
        val movieId: String
    ) : ScreenDestination

    @Serializable
    data class TrailerScreenDestination(
        val videoId: String
    ) : ScreenDestination
}