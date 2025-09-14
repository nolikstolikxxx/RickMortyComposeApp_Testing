package com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model

import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Location

data class Character(
    val id: Int ,
    val name: String ,
    val status: String ,
    val species: String ,
    val type: String ,
    val gender: String ,
    val location: Location ,
    val image: String ,
    val episode: List<Int>
)