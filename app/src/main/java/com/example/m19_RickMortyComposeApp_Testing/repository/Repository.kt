package com.example.m19_RickMortyComposeApp_Testing.repository

import com.example.m19_RickMortyComposeApp_Testing.repository.mappers.CastToListCharacter
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Characters
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Result
import com.example.m19_RickMortyComposeApp_Testing.repository.model.episodes.Episode
import com.example.m19_RickMortyComposeApp_Testing.repository.model.locations.Locations
import com.example.m19_RickMortyComposeApp_Testing.repository.model.locations.LocationsInfo
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model.Character
import kotlinx.coroutines.delay

object Repository {
    private val getRickAndMortyApi = RetrofitInstance.getApi()
    private val cache = mutableMapOf<Int , Character>()
    private val castToListCharacter = CastToListCharacter()

    suspend fun getCharacters(page: Int = 0): List<Result>? {
        val characters: Characters?
        characters = getRickAndMortyApi.getCharacters(page)

        castToListCharacter.castListResultToListCharacter(characters.results)
            // Write to the cache, as the information is duplicated on an additional detailed screen
            .map { character ->
                cache.put(character.id , character)
            }

        return characters.results
    }

    suspend fun getLocations(page: Int = 0): List<LocationsInfo>? {
        val locations: Locations?
        locations = getRickAndMortyApi.getLocations(page)
        delay(1000)
        return locations.results
    }

    fun getCharacterFromCache(id: Int): Character? {
        return cache[id]
    }

    suspend fun getEpisodesByIds(listId: List<Int>): List<Episode> {
        return getRickAndMortyApi.getEpisodes(listId.joinToString())
    }
}