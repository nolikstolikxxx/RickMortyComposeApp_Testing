package com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.example.m19_RickMortyComposeApp_Testing.repository.mappers.CastToListCharacter
import com.example.m19_RickMortyComposeApp_Testing.repository.Repository
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model.Character

class CharactersPagingSource(val repository: Repository) : PagingSource<Int , Character>() {
    private val castToListCharacter = CastToListCharacter()
    override fun getRefreshKey(state: PagingState<Int , Character>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int , Character> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            repository.getCharacters(page)
        }.fold(
            onSuccess = { it ->
                Page(
                    data = castToListCharacter.castListResultToListCharacter(it) ,
                    prevKey = params.key?.let { it - 1 } ,
                    nextKey = if (it?.isEmpty() == true) null else page + 1
                )
            } ,
            onFailure = { LoadResult.Error(it) }
        )
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}