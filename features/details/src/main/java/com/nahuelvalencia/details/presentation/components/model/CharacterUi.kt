package com.nahuelvalencia.details.presentation.components.model

import com.nahuelvalencia.details.domain.model.Category
import com.nahuelvalencia.details.domain.model.Character

data class CharacterUi(
    val name: String,
    val description: String,
    val image: String,
    val interestingNumbers: Map<String, Int>
)

fun Character.toUI(): CharacterUi = CharacterUi(
    name = name,
    description = description,
    image = image,
    interestingNumbers = interestingNumbers.mapKeys {
        when (it.key) {
            Category.COMICS -> "Comics"
            Category.SERIES -> "Series"
            Category.STORIES -> "Stories"
            Category.EVENTS -> "Events"
        }
    }
)