package com.example.lunchtray

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LunchTrayScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun startScreen_isDisplayed() {
        val nodes = composeTestRule
            .onAllNodesWithText("Start Order")
            .fetchSemanticsNodes()

        assertTrue("Start Order should be displayed", nodes.isNotEmpty())
    }
}
