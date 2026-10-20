package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class driversTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Hamilton")

        // add race location
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Hamilton")
            .assertExists()

        // clear list
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

}