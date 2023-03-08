package com.nahuelvalencia.details.presentation

import com.nahuelvalencia.network.error.NetworkError

internal sealed class CharacterDetailsEvent() {
    data class Init(val id: String) : CharacterDetailsEvent()
    object GoBack : CharacterDetailsEvent()
}

internal sealed class CharacterDetailsState() {
    object Loading : CharacterDetailsState()
    data class Content(val character: Character) : CharacterDetailsState()
    data class Error(val error: NetworkError) : CharacterDetailsState()
}

internal sealed class CharacterDetailsEffect {
    object None : CharacterDetailsEffect()
    object NavigateToHome : CharacterDetailsEffect()
}
