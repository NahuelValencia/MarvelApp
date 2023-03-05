package com.nahuelvalencia.home.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.nahuelvalencia.home.presentation.CharactersListViewModel
import com.nahuelvalencia.home.presentation.UiState

@Composable
fun HomeScreen(
    viewModel: CharactersListViewModel = hiltViewModel(),
    onClick: (Long) -> Unit
) {
    HomeScaffold(
        state = viewModel.state.collectAsState().value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScaffold(
    state: UiState
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "Marvel characters") }
            )
        }
    ) { paddingValues ->
        HomeScreenContent(paddingValues = paddingValues, state = state)
    }

}

@Composable
private fun HomeScreenContent(paddingValues: PaddingValues, state: UiState) {
    when (state) {
        is UiState.Content -> CharacterList(characters = state.list, paddingValues = paddingValues)
        is UiState.Error -> TODO()
        UiState.Loading -> LoadingStateComponent()
    }
}

@Composable
private fun LoadingStateComponent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
private fun CharacterList(characters: List<MarvelCharacter>, paddingValues: PaddingValues) {
    val lazyGridState = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        state = lazyGridState
    ) {
        items(characters) { item ->
            key(item.id) {
                CharacterCard(character = item)
            }
        }
    }

}
