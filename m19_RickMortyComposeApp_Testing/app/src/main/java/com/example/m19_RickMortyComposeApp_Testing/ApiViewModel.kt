package com.example.m19_RickMortyComposeApp_Testing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.m19_RickMortyComposeApp_Testing.repository.Repository
import com.example.m19_RickMortyComposeApp_Testing.repository.model.episodes.Episode
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.CharactersPagingSource
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model.Character
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.LocationsPagingSource
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class ApiViewModel : ViewModel() {
    val repository = Repository

    val pagesCharacters: Flow<PagingData<Character>> = Pager( // page-by-page loading of heroes
        config = PagingConfig(pageSize = 20) ,
        pagingSourceFactory = { CharactersPagingSource(repository) }
    ).flow.cachedIn(viewModelScope)

    val pagesLocations: Flow<PagingData<Location>> = Pager(//page-by-page loading of locations
        config = PagingConfig(pageSize = 20) ,
        pagingSourceFactory = { LocationsPagingSource(repository) }
    ).flow.cachedIn(viewModelScope)


    private val _characterFromCache =
        MutableStateFlow<Character?>(null)// information about the hero on a separate screen
    val characterFromCache = _characterFromCache.asStateFlow()

    private val _episodes =
        MutableStateFlow<List<Episode>?>(null)// episode information for a separate hero screen
    val episodes = _episodes.asStateFlow()

    fun loadCharacterFromCache(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {// uploading by hero
            kotlin.runCatching {
                repository.getCharacterFromCache(id)
            }.fold(
                onSuccess = { _characterFromCache.value = it } ,
                onFailure = {
                    Timber.tag("The problem with loading the selected hero").d(it.message ?: "")
                }
            )
        }
    }

    fun loadEpisodes(ids: List<Int>) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getEpisodesByIds(ids)// download for all episodes of the hero
            }.fold(
                onSuccess = { _episodes.value = it } ,
                onFailure = {
                    Timber.tag("The problem with downloading episodes").d(it.message ?: "")
                }
            )
        }
    }
}