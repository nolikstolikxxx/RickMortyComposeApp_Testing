package com.example.m19_RickMortyComposeApp_Testing.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Annotation class used to identify the base url of the Rick and Morty api as an injectable String
 */

annotation class RickAndMortyBaseUrl


class NetworkModule {

    fun provideRickAndMortyBaseUrl() = RICK_AND_MORTY_BASE_URL

    fun provideGson() = GsonBuilder().setDateFormat(TIME_FORMAT).create()

    fun provideRetrofit(@RickAndMortyBaseUrl baseUrl: String , gson: Gson) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun provideRickAndMortyApi(retrofit: Retrofit) = retrofit.create(RickAndMortyApi::class.java)

    internal companion object {
        const val TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val RICK_AND_MORTY_BASE_URL = "https://rickandmortyapi.com/api/"
    }
}