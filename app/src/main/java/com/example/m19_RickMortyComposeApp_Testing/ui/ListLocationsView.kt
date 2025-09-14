package com.example.m19_RickMortyComposeApp_Testing.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.m19_RickMortyComposeApp_Testing.ApiViewModel
import com.example.m19_RickMortyComposeApp_Testing.R
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.ItemLocationView
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.DeadColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.ProgressColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.RecyclerviewBackground

const val NO_INTERNET_BUTTON_TT = "no_internet_button_tt"

@Composable
fun ListLocationsView(viewModel: ApiViewModel) {
    val locationsData = viewModel.pagesLocations.collectAsLazyPagingItems()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp) ,
        modifier = Modifier
            .padding(top = 40.dp , start = 8.dp , end = 8.dp , bottom = 8.dp)
            .background(RecyclerviewBackground)
    ) {
        items(
            count = locationsData.itemCount ,
            key = locationsData.itemKey { it.id!! }) { index ->
            val location = locationsData[index]
            if (location != null) {
                ItemLocationView(location)
            }
        }
        when {
            locationsData.loadState.append is LoadState.Loading -> {
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

            locationsData.loadState.append is LoadState.Error -> {
                item {
                    Row(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(onClick = { locationsData.retry() } ,
                            modifier = Modifier.testTag(NO_INTERNET_BUTTON_TT)) {
                            Text(
                                text = stringResource(id = R.string.please_repeat_the_download)
                            )
                        }
                        Text(
                            color = DeadColor ,
                            text = stringResource(id = R.string.download_error) ,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }

            locationsData.loadState.refresh is LoadState.Loading -> {
                item {
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        CircularProgressIndicator(
                            color = ProgressColor ,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            locationsData.loadState.refresh is LoadState.Error -> {
                item {
                    Row(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(onClick = { locationsData.retry() } ,
                            modifier = Modifier.testTag(NO_INTERNET_BUTTON_TT)) {
                            Text(
                                text = stringResource(id = R.string.please_repeat_the_download)
                            )
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
fun ListLocationsViewPreview() {
    M19_RickMortyComposeApp_TestingTheme {
        ListLocationsView(viewModel = ApiViewModel())
    }
}