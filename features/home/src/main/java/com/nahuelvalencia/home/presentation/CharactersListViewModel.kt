package com.nahuelvalencia.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.nahuelvalencia.home.domain.usecase.GetCharacters
import com.nahuelvalencia.network.error.NetworkError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getCharacters: GetCharacters
) : ViewModel() {

    private val _state: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Loading)
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() = viewModelScope.launch {
        _state.value = UiState.Loading

        getCharacters().fold({ error ->
            handleError(error)
        }, { list ->
            handleResponse(list)
        })

    }

    private fun handleError(error: NetworkError) {
        Log.i("ViewModel", "Error: ${error.error}")
        _state.value = UiState.Error(error = error.error)
    }

    private fun handleResponse(characters: List<MarvelCharacter>) {
        Log.i("ViewModel", "Response: ${characters.map { it.image }}")
        _state.value = UiState.Content(list = characters)
    }

}
