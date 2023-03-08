package com.nahuelvalencia.details.domain.model

data class Character(
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
    val interestingNumbers: MutableMap<Category, Int>
)

enum class Category{
   COMICS,
   SERIES,
   STORIES,
   EVENTS
}
