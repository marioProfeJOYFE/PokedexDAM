package com.mrh.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokedexViewModel : ViewModel() {

    //_pokedex es privado y mutable, solo el ViewModel puede modificarlo
    private val _pokedex = MutableStateFlow<List<Region>>(emptyList())

    // pokedex es público e inmutable (StateFlow), para ser observada por la Interfaz de Usuario.
    val pokedex: StateFlow<List<Region>> = _pokedex.asStateFlow()

    fun marcarFavorito(pokemon: Pokemon) {
        val pokedexActual = _pokedex.value
        val regionActual = pokedexActual.find { it.pokemons.contains(pokemon) }
        val pokemonActual = regionActual?.pokemons?.find { it.id == pokemon.id }

        if (pokemonActual != null) {
            pokemonActual.favorito = !pokemonActual.favorito

        }
    }

    init {
        cargarPokedex()
    }


    private fun cargarPokedex() {
        viewModelScope.launch {
            _pokedex.value = listOf(
                Region(
                    id = 1,
                    name = "Kanto",
                    imageUrl = "https://images.wikidexcdn.net/mwuploads/wikidex/7/7e/latest/20081229145445/Mapa_de_Kanto_se%C3%B1alizado_RFVH.png",
                    pokemons = listOf(
                        Pokemon(
                            id = 1,
                            name = "Bulbasaur",
                            types = listOf("Grass", "Poison"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                            dexNumber = 1
                        ),
                        Pokemon(
                            id = 2,
                            name = "Ivysaur",
                            types = listOf("Grass", "Poison"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
                            dexNumber = 2
                        ),
                        Pokemon(
                            id = 3,
                            name = "Venusaur",
                            types = listOf("Grass", "Poison"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
                            dexNumber = 3
                        ),
                        Pokemon(
                            id = 4,
                            name = "Charmander",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
                            dexNumber = 4
                        ),
                        Pokemon(
                            id = 5,
                            name = "Charmeleon",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
                            dexNumber = 5
                        ),
                        Pokemon(
                            id = 6,
                            name = "Charizard",
                            types = listOf("Fire", "Flying"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
                            dexNumber = 6
                        ),
                        Pokemon(
                            id = 7,
                            name = "Squirtle",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
                            dexNumber = 7
                        ),
                        Pokemon(
                            id = 8,
                            name = "Wartortle",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
                            dexNumber = 8
                        ),
                        Pokemon(
                            id = 9,
                            name = "Blastoise",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
                            dexNumber = 9
                        )
                    )
                ),
                Region(
                    id = 2,
                    name = "Johto",
                    imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgpu7jHnKeEPU17Jl_o6DEvElg0LafKQhJfYYgRVy1A3XVMmq9YqG5O7TDQKO6P5oqXiDbLwnNcVFB_ZwniF6m5Vf-TcXXOrBTQZVXwzRNVt2Yr0FFO2KTEzLapH9a1Al97M-HixFnOLZaa/d/iris+pokemon+ciudad.jpg",
                    pokemons = listOf(
                        Pokemon(
                            id = 152,
                            name = "Chikorita",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png",
                            dexNumber = 152
                        ),
                        Pokemon(
                            id = 153,
                            name = "Bayleef",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/153.png",
                            dexNumber = 153
                        ),
                        Pokemon(
                            id = 154,
                            name = "Meganium",
                            types = listOf("Grass", "Poison"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/154.png",
                            dexNumber = 154
                        ),
                        Pokemon(
                            id = 155,
                            name = "Cyndaquil",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/155.png",
                            dexNumber = 155
                        ),
                        Pokemon(
                            id = 156,
                            name = "Quilava",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/156.png",
                            dexNumber = 156
                        ),
                        Pokemon(
                            id = 157,
                            name = "Typhlosion",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/157.png",
                            dexNumber = 157
                        ),
                        Pokemon(
                            id = 158,
                            name = "Totodile",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/158.png",
                            dexNumber = 158
                        ),
                        Pokemon(
                            id = 159,
                            name = "Croconaw",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/159.png",
                            dexNumber = 159
                        ),
                        Pokemon(
                            id = 160,
                            name = "Feraligatr",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/160.png",
                            dexNumber = 160
                        )
                    )
                ),
                Region(
                    id = 3,
                    name = "Hoenn",
                    imageUrl = "https://consolaytablero.com/wp-content/uploads/2014/09/mapa-de-hoenn-pokemon-rubi-omega-y-zafiro-alfa.jpg",
                    pokemons = listOf(
                        Pokemon(
                            id = 252,
                            name = "Treecko",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/252.png",
                            dexNumber = 252
                        ),
                        Pokemon(
                            id = 253,
                            name = "Grovyle",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/253.png",
                            dexNumber = 253
                        ),
                        Pokemon(
                            id = 254,
                            name = "Sceptile",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/254.png",
                            dexNumber = 254
                        ),
                        Pokemon(
                            id = 255,
                            name = "Torchic",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/255.png",
                            dexNumber = 255
                        ),
                        Pokemon(
                            id = 256,
                            name = "Combusken",
                            types = listOf("Fire", "Fighting"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/256.png",
                            dexNumber = 256
                        ),
                        Pokemon(
                            id = 257,
                            name = "Blaziken",
                            types = listOf("Fire", "Fighting"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/257.png",
                            dexNumber = 257
                        ),
                        Pokemon(
                            id = 258,
                            name = "Mudkip",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/258.png",
                            dexNumber = 258
                        ),
                        Pokemon(
                            id = 259,
                            name = "Marshtomp",
                            types = listOf("Water", "Ground"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/259.png",
                            dexNumber = 259

                        ),
                        Pokemon(
                            id = 260,
                            name = "Swampert",
                            types = listOf("Water", "Ground"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/260.png",
                            dexNumber = 260
                        )
                    )
                ),
                Region(
                    id = 4,
                    name = "Sinnoh",
                    imageUrl = "https://i.etsystatic.com/11277520/r/il/4268ca/2154562855/il_fullxfull.2154562855_cyf2.jpg",
                    pokemons = listOf(
                        Pokemon(
                            id = 387,
                            name = "Turtwig",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/387.png",
                            dexNumber = 387
                        ),
                        Pokemon(
                            id = 388,
                            name = "Grotle",
                            types = listOf("Grass"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/388.png",
                            dexNumber = 388
                        ),
                        Pokemon(
                            id = 389,
                            name = "Torterra",
                            types = listOf("Grass", "Ground"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/389.png",
                            dexNumber = 389
                        ),
                        Pokemon(
                            id = 390,
                            name = "Chimchar",
                            types = listOf("Fire"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/390.png",
                            dexNumber = 390
                        ),
                        Pokemon(
                            id = 391,
                            name = "Monferno",
                            types = listOf("Fire", "Fighting"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/391.png",
                            dexNumber = 391
                        ),
                        Pokemon(
                            id = 392,
                            name = "Infernape",
                            types = listOf("Fire", "Fighting"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/392.png",
                            dexNumber = 392
                        ),
                        Pokemon(
                            id = 393,
                            name = "Piplup",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/393.png",
                            dexNumber = 393
                        ),
                        Pokemon(
                            id = 394,
                            name = "Prinplup",
                            types = listOf("Water"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/394.png",
                            dexNumber = 394
                        ),
                        Pokemon(
                            id = 395,
                            name = "Empoleon",
                            types = listOf("Water", "Steel"),
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/395.png",
                            dexNumber = 395
                        )
                    )
                )
            )
        }
    }


}