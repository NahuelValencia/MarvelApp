package com.nahuelvalencia.details.presentation

import androidx.lifecycle.ViewModel
import com.nahuelvalencia.details.domain.usecase.GetCharacterById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
 * MVI pattern
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    getCharacterById: GetCharacterById
) : ViewModel() {

//    private val _state: MutableStateFlow<> = MutableStateFlow()

}
