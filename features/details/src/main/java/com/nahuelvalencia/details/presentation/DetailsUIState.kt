package com.nahuelvalencia.details.presentation

import com.nahuelvalencia.details.presentation.components.model.CharacterUi

sealed class DetailsUIState {
    object Loading : DetailsUIState()
    data class Content(val character: CharacterUi) : DetailsUIState()
    data class Error(val error: String) : DetailsUIState()
}
