package com.example.m19_RickMortyComposeApp_Testing.utils

import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Characters
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Info
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Origin
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Result
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location

object TestData {
    const val PREV = 1
    const val NEXT = 2
    const val PAGE_URL = "https://rickandmortyapi.com/api/character/?page="
    const val LOCATION_URL = "https://rickandmortyapi.com/api/location/"

    private val INFO_FIRST_PAGE = Info(
        count = 1 ,
        pages = 2 ,
        prev = null.toString() ,
        next = "${PAGE_URL}${NEXT}"
    )

    private val INFO_SECOND_PAGE = Info(
        count = 2 ,
        pages = 2 ,
        prev = "${PAGE_URL}${PREV}" ,
        next = null.toString()
    )

    private val CHARACTER = Result(
        id = 2 ,
        name = "Morty Smith" ,
        status = "Alive" ,
        species = "Human" ,
        type = "" ,
        gender = "Male" ,
        origin = Origin(name = "Earth" , url = "https://rickandmortyapi.com/api/location/1") ,
        location = com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Location(
            name = "Earth" ,
            url = "https://rickandmortyapi.com/api/location/20"
        ) ,
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg" ,
        episode = listOf("S03E07" , "S03E07") ,
        url = "https://rickandmortyapi.com/api/character/1" ,
        created = "2017-11-04T18:48:46.250Z"
    )

    val LOCATION = Location(
        id = 1 ,
        name = "Earth" ,
        type = "Planet" ,
        dimension = "Dimension C-137" ,
        residents = listOf(
            "https://rickandmortyapi.com/api/character/1" ,
            "https://rickandmortyapi.com/api/character/2"
        ) ,
        url = "https://rickandmortyapi.com/api/location/1" ,
        created = "2017-11-10T12:42:04.162Z"
    )

    val CHARACTER_RESPONSE_FIRST_PAGE = Characters(
        info = INFO_FIRST_PAGE ,
        results = listOf(CHARACTER)
    )

    val CHARACTER_RESPONSE_SECOND_PAGE = Characters(
        info = INFO_SECOND_PAGE ,
        results = listOf(CHARACTER)
    )

    val SHOW_CHARACTER = Result(
        id = CHARACTER.id ,
        name = CHARACTER.name ,
        status = CHARACTER.status ,
        species = CHARACTER.species ,
        type = CHARACTER.type ,
        gender = CHARACTER.gender ,
        origin = CHARACTER.origin ,
        location = CHARACTER.location ,
        image = CHARACTER.image ,
        episode = CHARACTER.episode ,
        url = CHARACTER.url ,
        created = CHARACTER.created ,
    )
}