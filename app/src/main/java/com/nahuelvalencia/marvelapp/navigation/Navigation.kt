package com.nahuelvalencia.marvelapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nahuelvalencia.details.presentation.screen.DetailsScreen
import com.nahuelvalencia.home.presentation.ui.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "charactersList"
    ) {

        composable(
            route = "charactersList"
        ) {
            HomeScreen { id ->
                navController.navigate("character_details/$id")
            }
        }
        composable(
            route = "character_details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong("id")
            requireNotNull(id)
            DetailsScreen(
                id = id,
                onBackPressed = { navController.navigateUp() }
            )
        }
    }

}
