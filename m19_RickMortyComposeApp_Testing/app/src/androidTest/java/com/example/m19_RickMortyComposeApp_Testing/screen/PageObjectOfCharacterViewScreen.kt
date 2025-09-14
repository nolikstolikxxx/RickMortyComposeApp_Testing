package com.example.m19_RickMortyComposeApp_Testing.screen

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.m19_RickMortyComposeApp_Testing.ui.CHARACTER_COLUMN_TT
import com.example.m19_RickMortyComposeApp_Testing.ui.CHARACTER_NAME_TT
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class PageObjectOfCharacterViewScreen(composeTestRule: ComposeTestRule) :
    ComposeScreen<PageObjectOfCharacterViewScreen>(composeTestRule) {
    val columnCharacter: KNode = child { hasTestTag(CHARACTER_COLUMN_TT) }
    val nameCharacter: KNode = columnCharacter.child {
        useUnmergedTree = true
        hasTestTag(CHARACTER_NAME_TT)
    }
}