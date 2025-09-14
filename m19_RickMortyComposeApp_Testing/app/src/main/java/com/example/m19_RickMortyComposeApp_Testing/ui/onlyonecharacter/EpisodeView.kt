package com.example.m19_RickMortyComposeApp_Testing.ui.onlyonecharacter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m19_RickMortyComposeApp_Testing.repository.model.episodes.Episode
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.CommentColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.ItemBackground
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.TextColor

@Composable
fun EpisodeView(episode: Episode) {
    Card(
        shape = RoundedCornerShape(10.dp) ,
        modifier = Modifier.fillMaxWidth() ,
        colors = CardDefaults.cardColors(
            containerColor = ItemBackground
        )
    )
    {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween ,
                modifier = Modifier.fillMaxWidth()
            ) {
                episode.name?.let {
                    Text(
                        text = it ,
                        fontSize = 16.sp ,
                        color = TextColor ,
                        fontWeight = FontWeight.Bold ,
                        modifier = Modifier.padding(top = 8.dp , start = 16.dp , bottom = 4.dp)
                    )
                }
                episode.episode?.let {
                    Text(
                        text = it ,
                        fontSize = 12.sp ,
                        color = CommentColor ,
                        modifier = Modifier.padding(top = 8.dp , bottom = 4.dp) ,
                    )
                }
            }

            episode.air_date?.let {
                Text(
                    text = it ,
                    fontSize = 12.sp ,
                    color = TextColor ,
                    modifier = Modifier.padding(bottom = 16.dp , start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeViewPreview() {
    M19_RickMortyComposeApp_TestingTheme {
        EpisodeView(
            episode = Episode(
                id = 28 ,
                name = "The Ricklantis Mixup" ,
                air_date = "September 10, 2017" ,
                episode = "S03E07" ,
                characters = listOf(
                    "https://rickandmortyapi.com/api/character/1" ,
                    "https://rickandmortyapi.com/api/character/2"
                ) ,
                url = "https://rickandmortyapi.com/api/episode/28" ,
                created = "2017-11-10T12:56:36.618Z"
            )
        )
    }
}
