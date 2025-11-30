package com.azxdev.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.azxdev.moviesapp.ui.screens.MainScreen
import com.azxdev.moviesapp.ui.screens.MovieDetailsScreen
import com.azxdev.moviesapp.ui.screens.TrailerScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenDestination.HomeScreenDestination,
        modifier = modifier
    )
    {
        composable<ScreenDestination.HomeScreenDestination> {
            MainScreen(navController = navController)
        }
        composable<ScreenDestination.MovieDetailsScreenDestination> {
            MovieDetailsScreen(navController = navController)
        }
        composable<ScreenDestination.TrailerScreenDestination> {
            val args = it.toRoute<ScreenDestination.TrailerScreenDestination>()
            TrailerScreen(navController = navController, videoId = args.videoUri)
        }
    }
}
