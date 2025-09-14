package com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m19_RickMortyComposeApp_Testing.ui.paginglocations.model.Location
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.CommentColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.ItemBackground
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.TextColor

@Composable
fun ItemLocationView(location: Location) {
    Card(
        shape = RoundedCornerShape(10.dp) ,
        modifier = Modifier.fillMaxWidth() ,
        colors = CardDefaults.cardColors(
            containerColor = ItemBackground
        )
    )
    {
        Column(
            horizontalAlignment = Alignment.Start ,
            verticalArrangement = Arrangement.Top ,
            modifier = Modifier
                .padding(start = 8.dp , top = 8.dp , bottom = 8.dp)
                .background(ItemBackground)
        ) {

            Row(
                horizontalArrangement = Arrangement.Start ,
                verticalAlignment = Alignment.CenterVertically ,
                modifier = Modifier.padding(top = 4.dp , bottom = 4.dp)
            ) {
                Text(
                    text = "Type location:" ,
                    fontSize = 14.sp ,
                    color = CommentColor
                )

                location.type?.let {
                    Text(
                        text = it ,
                        fontSize = 14.sp ,
                        color = TextColor ,
                        modifier = Modifier.padding(start = 8.dp , end = 24.dp)
                    )
                }

                Text(
                    text = "Name:" ,
                    fontSize = 14.sp ,
                    color = CommentColor
                )

                location.name?.let {
                    Text(
                        text = it ,
                        fontSize = 14.sp ,
                        color = TextColor ,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start ,
                verticalAlignment = Alignment.CenterVertically ,
                modifier = Modifier.padding(top = 4.dp , bottom = 4.dp)
            ) {
                Text(
                    text = "Dimension:" ,
                    fontSize = 14.sp ,
                    color = CommentColor
                )

                location.dimension?.let {
                    Text(
                        text = it ,
                        fontSize = 14.sp ,
                        color = TextColor ,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemLocationViewPreview() {
    M19_RickMortyComposeApp_TestingTheme {
        ItemLocationView(
            location = Location(
                id = 3 ,
                name = "Citadel of Ricks" ,
                type = "Space station" ,
                dimension = "unknown" ,
                url = "https://rickandmortyapi.com/api/location/3" ,
                created = "2017-11-10T13:08:13.191Z"
            )
        )
    }
}