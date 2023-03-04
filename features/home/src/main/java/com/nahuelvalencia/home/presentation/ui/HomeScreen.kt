package com.nahuelvalencia.home.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.nahuelvalencia.home.presentation.CharactersListViewModel

@Composable
fun HomeScreen(
    viewModel: CharactersListViewModel = hiltViewModel(),
    onClick: (Long) -> Unit
) {
    viewModel.load()
}
