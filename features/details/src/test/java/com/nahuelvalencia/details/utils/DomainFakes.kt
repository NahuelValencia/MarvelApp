package com.nahuelvalencia.details.utils

import com.nahuelvalencia.details.domain.model.Category
import com.nahuelvalencia.details.domain.model.Character

fun createDomainCharacter() = Character(
    id = 35422,
    name = "Super hero name",
    description = "Hero description",
    image = "https://www.somedomain.com/landscape_large.jpeg",
    interestingNumbers = mutableMapOf(
        Pair(Category.COMICS, 23),
        Pair(Category.SERIES, 2),
        Pair(Category.STORIES, 0),
        Pair(Category.EVENTS, 32)
    )
)