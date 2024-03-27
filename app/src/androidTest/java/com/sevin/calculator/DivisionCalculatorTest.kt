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

class DivisionCalculatorTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun divisionButtonWithoutNumbers() {
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithoutSecondNumber() {
        onView(withId(R.id.editN2)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithoutFirstNumber() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithPositiveNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 1.9230769230769231")))
    }

    @Test
    fun divisionButtonWithMixNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: -1.9230769230769231")))
    }

    @Test
    fun divisionButtonWithNegativeNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("-25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 1.9230769230769231")))
    }

    @Test
    fun divisionButtonNullNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: NaN")))
    }

    @Test
    fun divisionButtonWithNullNumber() {
        onView(withId(R.id.editN1)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: Infinity")))
    }

    @Test
    fun divisionButtonWithLetters() {
        onView(withId(R.id.editN1)).perform(typeText("a"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithLetterAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithSpecialSymbols() {
        onView(withId(R.id.editN1)).perform(typeText("*"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun divisionButtonWithSpecialSymbolAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("9"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }
}