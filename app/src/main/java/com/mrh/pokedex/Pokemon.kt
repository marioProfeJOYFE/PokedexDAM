package com.mrh.pokedex

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val imageUrl: String,
    val dexNumber: Int,
    var favorito: Boolean = false
)
