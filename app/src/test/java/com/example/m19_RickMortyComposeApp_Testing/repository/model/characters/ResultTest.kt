package com.example.m19_RickMortyComposeApp_Testing.repository.model.characters

import com.example.m19_RickMortyComposeApp_Testing.utils.TestData
import org.junit.Assert.assertNull
import org.junit.Test

internal class ResultTest {
    private lateinit var underTest: Result

    @Test
    fun `getLocationId returns null on null location`() {
        // Arrange
        underTest = Result()

        // Act
        val actual = underTest.getLocationId()

        // Assert
        assertNull(actual)
    }

    @Test
    fun `getLocationId returns null on null location url`() {
        // Arrange
        underTest = Result(location = Location())

        // Act
        val actual = underTest.getLocationId()

        // Assert
        assertNull(actual)
    }

    @Test
    fun `getNextPage returns null on empty location url`() {
        // Arrange
        underTest = Result(
            location = Location(
                url = ""
            )
        )

        // Act
        val actual = underTest.getLocationId()

        // Assert
        assertNull(actual)
    }

    @Test
    fun `getNextPage returns null on invalid url`() {
        // Arrange
        underTest = Result(
            location = Location(
                url = "some invalid url"
            )
        )

        // Act
        val actual = underTest.getLocationId()

        // Assert
        assertNull(actual)
    }

    @Test
    fun `getNextPage returns null on url with missing page`() {
        // Arrange
        underTest = Result(
            location = Location(
                url = TestData.LOCATION_URL
            )
        )

        // Act
        val actual = underTest.getLocationId()

        // Assert
        assertNull(actual)
    }
}
