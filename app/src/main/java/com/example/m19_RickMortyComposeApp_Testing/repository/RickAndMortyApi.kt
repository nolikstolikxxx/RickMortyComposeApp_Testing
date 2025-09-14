package com.example.m19_RickMortyComposeApp_Testing.repository

import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Characters
import com.example.m19_RickMortyComposeApp_Testing.repository.model.episodes.Episode
import com.example.m19_RickMortyComposeApp_Testing.repository.model.locations.Locations
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int): Characters

    @GET("/api/location")
    suspend fun getLocations(@Query("page") page: Int): Locations

    @GET("/api/episode/{ids}")
    suspend fun getEpisodes(@Path("ids") ids: String): List<Episode>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Characters

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Location
}