package com.example.m19_RickMortyComposeApp_Testing.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.m19_RickMortyComposeApp_Testing.ApiViewModel
import com.example.m19_RickMortyComposeApp_Testing.R
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.ItemCharacterView
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.DeadColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.ProgressColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.RecyclerviewBackground

const val LIST_OF_CHARACTERS_TT = "list_of_characters_tt"

@Composable
fun ListCharactersView(
    viewModel: ApiViewModel ,
    navController: NavHostController
) {
    val charactersData = viewModel.pagesCharacters.collectAsLazyPagingItems()
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState ,
        verticalArrangement = Arrangement.spacedBy(10.dp) ,
        modifier = Modifier
            .padding(top = 40.dp , start = 8.dp , end = 8.dp , bottom = 8.dp)
            .background(RecyclerviewBackground)
            .testTag(LIST_OF_CHARACTERS_TT)

    ) {

        items(
            count = charactersData.itemCount ,
            key = charactersData.itemKey { it.id }) { index ->
            val character = charactersData[index]
            if (character != null) {
                ItemCharacterView(character , navController , viewModel , "$index")
            }
        }
        when {
            charactersData.loadState.append is LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(top = 26.dp)
                    ) {
                        CircularProgressIndicator(
                            color = ProgressColor ,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            charactersData.loadState.append is LoadState.Error -> {
                item {
                    Row(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(onClick = { charactersData.retry() })
                        {
                            Text(text = stringResource(id = R.string.please_repeat_the_download))
                        }
                        Text(
                            color = DeadColor ,
                            text = stringResource(id = R.string.download_error) ,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }

            charactersData.loadState.refresh is LoadState.Loading -> {
                item {
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        CircularProgressIndicator(
                            color = ProgressColor ,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            charactersData.loadState.refresh is LoadState.Error -> {
                item {
                    Row(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(onClick = { charactersData.retry() })
                        {
                            Text(text = stringResource(id = R.string.please_repeat_the_download))
                        }
                        Text(
                            color = DeadColor ,
                            text = stringResource(id = R.string.download_error) ,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
fun ListCharactersViewPreview() {
    M19_RickMortyComposeApp_TestingTheme {
        ListCharactersView(viewModel = ApiViewModel() , navController = rememberNavController())
    }
}