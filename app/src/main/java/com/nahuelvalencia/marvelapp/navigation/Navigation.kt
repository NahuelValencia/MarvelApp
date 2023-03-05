package com.nahuelvalencia.marvelapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            HomeScreen { id -> id
//                navController.navigate("character_detail/$id")
            }
        }
    }

}
