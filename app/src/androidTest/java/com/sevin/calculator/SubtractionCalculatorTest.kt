package com.sevin.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class SubtractionCalculatorTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun subtractionButtonWithoutNumbers() {
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithoutSecondNumber() {
        onView(withId(R.id.editN2)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithoutFirstNumber() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithPositiveNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 12.0")))
    }

    @Test
    fun subtractionButtonWithMixNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 38.0")))
    }

    @Test
    fun subtractionButtonWithNegativeNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("-25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: -12.0")))
    }

    @Test
    fun subtractionButtonNullNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 0.0")))
    }

    @Test
    fun subtractionButtonWithNullNumber() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: -1.0")))
    }

    @Test
    fun subtractionButtonWithLetters() {
        onView(withId(R.id.editN1)).perform(typeText("a"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithLetterAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithSpecialSymbols() {
        onView(withId(R.id.editN1)).perform(typeText("*"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun subtractionButtonWithSpecialSymbolAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("9"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.subtraction)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }
}