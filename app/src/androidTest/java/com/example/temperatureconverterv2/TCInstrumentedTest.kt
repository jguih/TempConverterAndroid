package com.example.temperatureconverterv2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TCInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test fun celsius_text_layout_exists() {
        onView(withId(R.id.celsius_text_layout)).check(matches(isDisplayed()))
    }
    @Test fun fahrenheit_text_layout_exists() {
        onView(withId(R.id.fahrenheit_text_layout)).check(matches(isDisplayed()))
    }
    @Test fun kelvin_text_layout_exists() {
        onView(withId(R.id.kelvin_text_layout)).check(matches(isDisplayed()))
    }
    @Test fun conversion_celsius() {
        onView(withId(R.id.celsius_text_input)).perform(click(), typeText("0"))
        onView(withId(R.id.fahrenheit_text_input)).check(matches(withText("32")))
        onView(withId(R.id.kelvin_text_input)).check(matches(withText("273.15")))
    }
    @Test fun conversion_fahrenheit() {
        onView(withId(R.id.fahrenheit_text_input)).perform(click(), typeText("32"))
        onView(withId(R.id.celsius_text_input)).check(matches(withText("0")))
        onView(withId(R.id.kelvin_text_input)).check(matches(withText("273.15")))
    }
    @Test fun conversion_kelvin() {
        onView(withId(R.id.kelvin_text_input)).perform(click(), typeText("0"))
        onView(withId(R.id.celsius_text_input)).check(matches(withText("-273.15")))
        onView(withId(R.id.fahrenheit_text_input)).check(matches(withText("-459.67")))
    }
    @Test fun clear_text_after_conversion_celsius() {
        conversion_celsius()
        onView(withId(R.id.celsius_text_input)).perform(clearText())
        onView(withId(R.id.fahrenheit_text_input)).check(matches(withText("")))
        onView(withId(R.id.kelvin_text_input)).check(matches(withText("")))
    }
    @Test fun change_fahrenheit_input_after_conversion_celsius() {
        conversion_celsius()
        onView(withId(R.id.fahrenheit_text_input)).perform(click(), typeText("2"))
        onView(withId(R.id.celsius_text_input)).check(matches(withText("161.11")))
        onView(withId(R.id.kelvin_text_input)).check(matches(withText("434.26")))
    }
}