package com.example.m19_RickMortyComposeApp_Testing.repository.mappers

import com.example.m19_RickMortyComposeApp_Testing.repository.model.characters.Result
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model.Character

class CastToListCharacter {
    fun castListResultToListCharacter(listResult: List<Result>?): List<Character> {
        val characterList = mutableListOf<Character>()
        listResult?.map { result ->
            val character = Character(
                result.id!! ,
                result.name!! ,
                result.status!! ,
                result.species!! ,
                result.type!! ,
                result.gender!! ,
                result.location!! ,
                result.image!! ,
                result.episode!!.map { episode ->
                    (episode.substring(
                        episode.lastIndexOf("/") + 1 ,
                        episode.length
                    )).toInt()
                }

            )
            characterList.add(character)
        }
        return characterList
    }
}