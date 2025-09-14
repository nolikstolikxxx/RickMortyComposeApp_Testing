package com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.m19_RickMortyComposeApp_Testing.ApiViewModel
import com.example.m19_RickMortyComposeApp_Testing.NavigationMenuItem
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.model.Character
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.AliveColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.CommentColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.DeadColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.ItemBackground
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.TextColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.UnknownColor

const val ITEM_NAME_TT = "item_name_tt"
const val ITEM_ROW_TT = "item_row_tt"
const val ITEM_COLUMN_TT = "item_column_tt"

@Composable
fun ItemCharacterView(
    character: Character ,
    navController: NavController ,
    viewModel: ApiViewModel , testTag: String
) {
    Card(
        shape = RoundedCornerShape(10.dp) ,
        modifier = Modifier.fillMaxWidth() ,
        colors = CardDefaults.cardColors(
            containerColor = ItemBackground
        ) ,
        onClick = {
            viewModel.loadCharacterFromCache(character.id)
            viewModel.loadEpisodes(character.episode)
            navController.navigate(NavigationMenuItem.SCREEN_2)
        }
    ) {
        Row(modifier = Modifier.testTag("${ITEM_ROW_TT}_${testTag}")) {
            AsyncImage(
                model = character.image ,
                contentDescription = "Character pic" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start ,
                verticalArrangement = Arrangement.Top ,
                modifier = Modifier
                    .padding(start = 8.dp , top = 8.dp , bottom = 8.dp)
                    .background(ItemBackground)
                    .testTag("${ITEM_COLUMN_TT}_${testTag}")
            ) {
                Text(
                    text = character.name ,
                    fontWeight = FontWeight.Bold ,
                    fontSize = 20.sp ,
                    color = TextColor ,
                    modifier = Modifier.testTag("${ITEM_NAME_TT}_${testTag}")
                )
                Row(
                    horizontalArrangement = Arrangement.Start ,
                    verticalAlignment = Alignment.CenterVertically ,
                    modifier = Modifier.padding(top = 4.dp , bottom = 4.dp)
                ) {
                    val currentColor = when (character.status) {
                        "Alive" -> AliveColor
                        "Dead" -> DeadColor
                        else -> UnknownColor
                    }
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(currentColor , shape = RoundedCornerShape(12.dp))
                    )
                    Text(
                        text = "${character.status} - ${character.species}" ,
                        fontSize = 14.sp ,
                        color = TextColor ,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = "Last known location:" ,
                    fontSize = 14.sp ,
                    color = CommentColor
                )
                character.location.name?.let {
                    Text(
                        text = it ,
                        fontSize = 14.sp ,
                        color = TextColor
                    )
                }
            }
        }
    }
}
