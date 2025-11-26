package com.azxdev.moviesapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenDestination {

    @Serializable
    object HomeScreenDestination : ScreenDestination
}