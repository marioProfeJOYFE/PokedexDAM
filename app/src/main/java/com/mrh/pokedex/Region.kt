package com.mrh.pokedex

data class Region(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val pokemons: List<Pokemon>,
)
