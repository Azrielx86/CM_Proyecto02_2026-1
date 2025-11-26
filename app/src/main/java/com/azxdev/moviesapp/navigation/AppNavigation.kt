package com.azxdev.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.azxdev.moviesapp.ui.screens.MainScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenDestination.HomeScreenDestination,
        modifier = modifier
    )
    {
        composable<ScreenDestination.HomeScreenDestination> {
            MainScreen()
        }
    }
}