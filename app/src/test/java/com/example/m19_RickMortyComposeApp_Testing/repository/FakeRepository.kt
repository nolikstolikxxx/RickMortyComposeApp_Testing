package com.example.m19_RickMortyComposeApp_Testing.repository

import com.example.m19_RickMortyComposeApp_Testing.TestResponseEnum
import com.example.m19_RickMortyComposeApp_Testing.characterResponseItemList
import com.example.m19_RickMortyComposeApp_Testing.repository.entity.CharacterEntity
import com.example.m19_RickMortyComposeApp_Testing.repository.mappers.CharacterListMapperImpl
import com.example.m19_RickMortyComposeApp_Testing.repository.mappers.LocationListMapperImpl
import com.example.m19_RickMortyComposeApp_Testing.resultList
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class FakeRepository(
    private val locationMapper: LocationListMapperImpl ,
    private val characterMapper: CharacterListMapperImpl
) : RickAndMortyRepository {
    private var testRequest = TestResponseEnum.LOADING

    fun setRequest(testRequest: TestResponseEnum) {
        this.testRequest = testRequest
    }

    override suspend fun getLocations(pageNumber: Int): Flow<NetworkResponseState<List<Location>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (testRequest) {
                TestResponseEnum.LOADING -> emit(NetworkResponseState.Loading)
                TestResponseEnum.ERROR -> emit(NetworkResponseState.Error(Exception("An error has occurred")))
                TestResponseEnum.SUCCESS -> emit(
                    NetworkResponseState.Success(
                        locationMapper.map(
                            resultList
                        )
                    )
                )
            }
        }

    override suspend fun getCharactersById(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (testRequest) {
                TestResponseEnum.LOADING -> emit(NetworkResponseState.Loading)
                TestResponseEnum.ERROR -> emit(NetworkResponseState.Error(Exception("An error has occurred")))
                TestResponseEnum.SUCCESS -> emit(
                    NetworkResponseState.Success(
                        characterMapper.map(
                            characterResponseItemList
                        )
                    )
                )
            }
        }

    override fun getIsAppFirstOpenState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAppFirstOpenState(state: Boolean) {
        TODO("Not yet implemented")
    }
}