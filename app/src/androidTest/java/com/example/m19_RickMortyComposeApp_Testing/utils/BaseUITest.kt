package com.example.m19_RickMortyComposeApp_Testing.utils

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.m19_RickMortyComposeApp_Testing.MainActivity
import com.example.m19_RickMortyComposeApp_Testing.repository.RetrofitInstance.client
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseUITest {
    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

    private val idlingResource =
        OkHttp3IdlingResource.create("okhttp" , client)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {

            override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                if (parent !is ViewGroup) return false
                if (!parentMatcher.matches(parent)) return false
                if (parent.childCount <= childPosition) return false
                return parent.getChildAt(childPosition) == view
            }

            override fun describeTo(description: Description) {
                description.appendText("Nth child at position $childPosition of parent ")
                parentMatcher.describeTo(description)
            }
        }
    }
}