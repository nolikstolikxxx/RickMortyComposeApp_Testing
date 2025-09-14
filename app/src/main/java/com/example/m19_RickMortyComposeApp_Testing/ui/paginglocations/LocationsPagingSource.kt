package com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.example.m19_RickMortyComposeApp_Testing.repository.Repository
import com.example.m19_RickMortyComposeApp_Testing.repository.model.locations.LocationsInfo
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location

class LocationsPagingSource(val repository: Repository) : PagingSource<Int , Location>() {
    override fun getRefreshKey(state: PagingState<Int , Location>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int , Location> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            repository.getLocations(page)
        }.fold(
            onSuccess = { it ->
                Page(
                    data = castListResultToListLocation(it) ,
                    prevKey = params.key?.let { it - 1 } ,
                    nextKey = if (it?.isEmpty() == true) null else page + 1
                )
            } ,
            onFailure = { LoadResult.Error(it) }
        )
    }

    private fun castListResultToListLocation(listResult: List<LocationsInfo>?): List<Location> {
        val locationList = mutableListOf<Location>()
        listResult?.map { result ->
            val location = Location(
                result.id ,
                result.name ,
                result.type ,
                result.dimension ,
                result.residents ,
                result.url ,
                result.created
            )
            locationList.add(location)
        }
        return locationList
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}