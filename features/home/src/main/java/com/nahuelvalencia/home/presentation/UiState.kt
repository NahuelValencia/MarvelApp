package com.nahuelvalencia.home.presentation

import com.nahuelvalencia.home.domain.model.MarvelCharacter

sealed class UiState {
    object Loading : UiState()
    data class Content(val list: List<MarvelCharacter>) : UiState()
    data class Error(val error: String) : UiState()
}
