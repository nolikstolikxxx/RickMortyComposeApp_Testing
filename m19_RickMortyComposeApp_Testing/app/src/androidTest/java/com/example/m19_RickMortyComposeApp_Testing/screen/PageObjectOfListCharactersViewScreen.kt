package com.example.m19_RickMortyComposeApp_Testing.screen

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.m19_RickMortyComposeApp_Testing.ui.LIST_OF_CHARACTERS_TT
import com.example.m19_RickMortyComposeApp_Testing.ui.pagingcharacters.ITEM_NAME_TT
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class PageObjectOfListCharactersViewScreen(composeTestRule: ComposeTestRule) :
    ComposeScreen<PageObjectOfListCharactersViewScreen>(composeTestRule) {
    val listCharacters: KNode = child { hasTestTag(LIST_OF_CHARACTERS_TT) }

    val menuButtonGoToListLocationView: KNode = child {
        useUnmergedTree = true
        hasTestTag("menu_button_2")
    }

    val nameCharacter: KNode = listCharacters.child {
        useUnmergedTree = true
        hasTestTag("${ITEM_NAME_TT}_1")
    }
}