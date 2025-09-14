package com.example.m19_RickMortyComposeApp_Testing.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.m19_RickMortyComposeApp_Testing.MainActivity
import com.example.m19_RickMortyComposeApp_Testing.screen.PageObjectOfListCharactersViewScreen
import com.example.m19_RickMortyComposeApp_Testing.screen.PageObjectOfListLocationsViewScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class NoInternetTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withComposeSupport()) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val mainScreen = PageObjectOfListCharactersViewScreen(composeTestRule)
    private val locationsScreen = PageObjectOfListLocationsViewScreen(composeTestRule)

    @Test
    fun checkNoInternetEvent() =
        before { device.network.disable() }.after { device.network.enable() }.run {
            step("Checking for the repeat download button when the Internet is turned off") {
                mainScreen.menuButtonGoToListLocationView.assertIsDisplayed()
                mainScreen.menuButtonGoToListLocationView.performClick()
                val timeout = 6000L
                val interval = 250L
                var elapsed = 0L
                while (elapsed < timeout) {
                    try {
                        locationsScreen.noInternetButton.assertIsDisplayed()
                        break
                    } catch (e: AssertionError) {
                        Thread.sleep(interval)
                        elapsed += interval
                    }
                }
            }
        }
}
