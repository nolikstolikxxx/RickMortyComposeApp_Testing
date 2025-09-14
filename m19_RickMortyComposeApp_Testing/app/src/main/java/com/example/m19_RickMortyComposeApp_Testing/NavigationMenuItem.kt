package com.example.m19_RickMortyComposeApp_Testing

import androidx.compose.ui.res.stringResource


sealed class NavigationMenuItem(val title: Int , val icon: Int , val route: String) {

    data object ListCharactersScreen :
        NavigationMenuItem(R.string.characters , R.drawable.ic_list_characters , SCREEN_1)

    data object CharacterScreen :
        NavigationMenuItem(R.string.details , R.drawable.ic_details , SCREEN_2)

    data object ListLocationsScreen :
        NavigationMenuItem(R.string.locations , R.drawable.ic_locations , SCREEN_3)

    companion object {
        const val SCREEN_1 = "SCREEN_1"
        const val SCREEN_2 = "SCREEN_2"
        const val SCREEN_3 = "SCREEN_3"
    }
}