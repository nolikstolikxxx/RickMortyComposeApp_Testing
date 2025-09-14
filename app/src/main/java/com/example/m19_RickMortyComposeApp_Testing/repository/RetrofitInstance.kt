package com.example.m19_RickMortyComposeApp_Testing.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://rickandmortyapi.com"

object RetrofitInstance {
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()


    fun getApi(): RickAndMortyApi {
        return retrofit.create(RickAndMortyApi::class.java)
    }
}