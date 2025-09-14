package com.example.m19_RickMortyComposeApp_Testing.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.m19_RickMortyComposeApp_Testing.NavigationMenuItem
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.CommentColor
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.FragmentBackground
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.SelectedColor

@Composable
fun AppBottomNavigation(navController: NavController = rememberNavController()) {
    val listScreens = listOf(
        NavigationMenuItem.ListCharactersScreen ,
        NavigationMenuItem.CharacterScreen ,
        NavigationMenuItem.ListLocationsScreen
    )
    NavigationBar(contentColor = FragmentBackground) {
        val backstackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backstackEntry?.destination?.route ?: NavigationMenuItem.SCREEN_1
        listScreens.forEachIndexed { index , item ->
            NavigationBarItem(
                selected = currentRoute == item.route , icon = {
                    Icon(
                        painter = painterResource(item.icon) , contentDescription = "icon screen"
                    )
                } , onClick = {
                    navController.navigate(item.route) { popUpTo(item.route) { inclusive = true } }
                } ,
                label = {
                    Text(
                        text = stringResource(id =  item.title) ,
                        modifier = Modifier.testTag("menu_button_${index}")
                    )
                } ,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SelectedColor ,
                    selectedTextColor = SelectedColor ,
                    unselectedIconColor = CommentColor ,
                    unselectedTextColor = CommentColor
                )
            )
        }
    }
}

@Preview
@Composable
fun AppBottomNavigationPreview() {
    M19_RickMortyComposeApp_TestingTheme {
        AppBottomNavigation(navController = rememberNavController())
    }
}