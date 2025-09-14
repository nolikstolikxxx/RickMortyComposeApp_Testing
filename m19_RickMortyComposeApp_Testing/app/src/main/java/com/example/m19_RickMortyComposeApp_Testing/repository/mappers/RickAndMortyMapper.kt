package com.example.m19_RickMortyComposeApp_Testing.repository.mappers

interface RickAndMortyMapper<I , O> {
    fun map(input: I?): O
}