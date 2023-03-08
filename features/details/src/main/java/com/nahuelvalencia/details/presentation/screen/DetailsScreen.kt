package com.nahuelvalencia.details.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import com.nahuelvalencia.details.presentation.DetailsUIState
import com.nahuelvalencia.details.presentation.DetailsViewModel
import com.nahuelvalencia.details.presentation.components.CharacterInformation

@Composable
fun DetailsScreen(
    id: Long,
    viewModel: DetailsViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {

    var firstTime by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit, block = {
        if (firstTime) {
            viewModel.loadCharacterById(id = id)
            firstTime = false
        }
    })

    DetailsScaffold(
        state = viewModel.state.collectAsState().value,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScaffold(
    state: DetailsUIState,
    onBackPressed: () -> Unit
) {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { },
                navigationIcon = {
                    NavBarIconButton(icon = Icons.Filled.ArrowBack, description = "Back button") {
                        onBackPressed()
                    }
                },
                actions = { //TODO (Add Favorites)
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CharacterDetailsContent(state = state)
        }
    }

}

@Composable
private fun NavBarIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(
        modifier = Modifier
            .background(color = Color.White, shape = CircleShape),
        onClick = onClick
    ) {
        Icon(icon, description)
    }
}

@Composable
private fun CharacterDetailsContent(state: DetailsUIState) {
    when (state) {
        is DetailsUIState.Content -> CharacterInformation(character = state.character)
        is DetailsUIState.Error -> {}//TODO()
        DetailsUIState.Loading -> {
            LoadingStateComponent()
        }
    }
}

@Composable
private fun LoadingStateComponent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}
