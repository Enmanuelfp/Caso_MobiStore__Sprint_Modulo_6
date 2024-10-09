package com.bootcamp.caso_mobistore__sprint_modulo_6

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bootcamp.caso_mobistore__sprint_modulo_6.navigation.NavManager
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.runner.RunWith

import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)
    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeView_displaysTitle() {
        composeTestRule.activity.setContent {
            NavManager()
        }


        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.home_title))
            .assertIsDisplayed()
    }

}