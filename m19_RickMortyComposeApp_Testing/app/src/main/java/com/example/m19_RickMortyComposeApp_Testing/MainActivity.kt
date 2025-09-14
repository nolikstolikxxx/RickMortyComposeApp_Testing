package com.example.m19_RickMortyComposeApp_Testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m19_RickMortyComposeApp_Testing.ui.AppBottomNavigation
import com.example.m19_RickMortyComposeApp_Testing.ui.CharacterView
import com.example.m19_RickMortyComposeApp_Testing.ui.ListCharactersView
import com.example.m19_RickMortyComposeApp_Testing.ui.ListLocationsView
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.FragmentBackground
import com.example.m19_RickMortyComposeApp_Testing.ui.theme.M19_RickMortyComposeApp_TestingTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ApiViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M19_RickMortyComposeApp_TestingTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { AppBottomNavigation(navController) } ,
                    contentColor = FragmentBackground
                )
                { paddingValues ->
                    AppNavigation(
                        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()) ,
                        navController
                    )
                }
            }
        }
    }

    @Composable
    fun AppNavigation(modifier: Modifier , navController: NavHostController) {
        NavHost(
            modifier = modifier ,
            navController = navController ,
            startDestination = NavigationMenuItem.SCREEN_1
        ) {
            composable(NavigationMenuItem.SCREEN_1) {
                ListCharactersView(
                    viewModel ,
                    navController
                )
            }
            composable(NavigationMenuItem.SCREEN_2) { CharacterView(viewModel) }
            composable(NavigationMenuItem.SCREEN_3) { ListLocationsView(viewModel) }
        }
    }
}