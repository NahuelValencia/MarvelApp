package com.nahuelvalencia.details.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahuelvalencia.details.domain.model.Character
import com.nahuelvalencia.details.domain.usecase.GetCharacterById
import com.nahuelvalencia.details.presentation.components.model.toUI
import com.nahuelvalencia.network.error.NetworkError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    val getCharacterById: GetCharacterById
) : ViewModel() {

    private val _state: MutableStateFlow<DetailsUIState> =
        MutableStateFlow(DetailsUIState.Loading)
    val state: StateFlow<DetailsUIState> = _state.asStateFlow()

    fun loadCharacterById(id: Long) = viewModelScope.launch {
        _state.value = DetailsUIState.Loading

        getCharacterById(characterId = id).fold({ error ->
            handleError(error)
        }, { character ->
            handleResponse(character)
        })

    }

    private fun handleError(error: NetworkError) {
        _state.value = DetailsUIState.Error(error = error.error)
    }

    private fun handleResponse(character: Character) {
        val characterUI = character.toUI()
        _state.value = DetailsUIState.Content(character = characterUI)
    }

}
