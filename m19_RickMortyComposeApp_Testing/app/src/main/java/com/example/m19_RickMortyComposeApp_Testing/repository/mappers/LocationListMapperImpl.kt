package com.example.m19_RickMortyComposeApp_Testing.repository.mappers

import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location

class LocationListMapperImpl : RickAndMortyListMapper<Location , Location> {

    override fun map(input: List<Location>?): List<Location> {
        return input?.map {
            Location(
                id = it.id ,
                name = it.name ,
                residents = it.residents
            )
        } ?: emptyList()
    }
}