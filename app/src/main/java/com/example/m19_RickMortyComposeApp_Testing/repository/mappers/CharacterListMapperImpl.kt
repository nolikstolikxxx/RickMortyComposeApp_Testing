package com.example.m19_RickMortyComposeApp_Testing.repository.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.m19_RickMortyComposeApp_Testing.repository.entity.CharacterEntity
import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Result
import com.example.m19_RickMortyComposeApp_Testing.utility.dateTimeConverter
import com.example.m19_RickMortyComposeApp_Testing.utility.getEpisodes

class CharacterListMapperImpl : RickAndMortyListMapper<Result , CharacterEntity> {
    override fun map(input: List<Result>?): List<CharacterEntity> {
        return input?.map { result ->
            CharacterEntity(
                created = result.created!!.dateTimeConverter() ,
                episode = result.episode!!.getEpisodes() ,
                gender = result.gender!! ,
                id = result.id!! ,
                image = result.image!! ,
                location = result.location?.name!! ,
                name = result.name!! ,
                origin = result.origin?.name!! ,
                species = result.species!! ,
                status = result.status!!
            )
        } ?: emptyList()
    }
}