package com.example.m19_RickMortyComposeApp_Testing.repository

import com.example.m19_RickMortyComposeApp_Testing.repository.entity.CharacterEntity
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getLocations(pageNumber: Int): Flow<NetworkResponseState<List<Location>>>

    suspend fun getCharactersById(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>>

    fun getIsAppFirstOpenState(): Flow<Boolean>

    suspend fun saveAppFirstOpenState(state: Boolean)
}