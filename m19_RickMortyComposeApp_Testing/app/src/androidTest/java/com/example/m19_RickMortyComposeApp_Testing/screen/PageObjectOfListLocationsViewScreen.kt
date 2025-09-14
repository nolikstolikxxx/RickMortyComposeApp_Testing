package com.example.m19_RickMortyComposeApp_Testing.screen

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.m19_RickMortyComposeApp_Testing.ui.NO_INTERNET_BUTTON_TT
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class PageObjectOfListLocationsViewScreen(composeTestRule: ComposeTestRule) :
    ComposeScreen<PageObjectOfListLocationsViewScreen>(composeTestRule) {
    val noInternetButton: KNode = child {
        useUnmergedTree = true
        hasTestTag(NO_INTERNET_BUTTON_TT)
    }
}