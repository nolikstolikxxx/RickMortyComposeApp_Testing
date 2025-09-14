package com.example.m19_RickMortyComposeApp_Testing.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.m19_RickMortyComposeApp_Testing.MainActivity
import com.example.m19_RickMortyComposeApp_Testing.screen.PageObjectOfCharacterViewScreen
import com.example.m19_RickMortyComposeApp_Testing.screen.PageObjectOfListCharactersViewScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class ListCharactersViewTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withComposeSupport()) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val mainScreen = PageObjectOfListCharactersViewScreen(composeTestRule)
    private val characterScreen = PageObjectOfCharacterViewScreen(composeTestRule)

    @Test

    fun checkListCharactersView() = run {

        step("Checking for LazyColumn item with index 1 on the main screen - character") {
            mainScreen.listCharacters.assertIsDisplayed()
            mainScreen.nameCharacter.assertIsDisplayed()
            mainScreen.nameCharacter.assertTextEquals(NAME)
            mainScreen.nameCharacter.performClick()
        }
        step("Checking the CharacterView screen opening with a character from step 1") {
            characterScreen.columnCharacter.assertIsDisplayed()
            characterScreen.nameCharacter.assertIsDisplayed()
            characterScreen.nameCharacter.assertTextEquals(NAME)
        }
    }

    companion object {
        const val NAME = "Morty Smith"
    }
}