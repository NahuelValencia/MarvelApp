package com.nahuelvalencia.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahuelvalencia.home.domain.usecase.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getCharacters: GetCharacters
) : ViewModel() {

    fun load() = viewModelScope.launch {
        getCharacters().fold({
            Log.i("ViewModel", "Error: ${it.error}")
        }, { list ->
            list.map {
                Log.i("ViewModel", "Character name: ${it.name}")
            }
        })
    }
    
}
