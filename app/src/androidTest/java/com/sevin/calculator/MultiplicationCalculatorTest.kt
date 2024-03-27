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

class MultiplicationCalculatorTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun multiplicationButtonWithoutNumbers() {
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithoutSecondNumber() {
        onView(withId(R.id.editN2)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithoutFirstNumber() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithPositiveNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 325.0")))
    }

    @Test
    fun multiplicationButtonWithMixNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: -325.0")))
    }

    @Test
    fun multiplicationButtonWithNegativeNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("-25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 325.0")))
    }

    @Test
    fun multiplicationButtonNullNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 0.0")))
    }

    @Test
    fun multiplicationButtonWithNullNumber() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 0.0")))
    }

    @Test
    fun multiplicationButtonWithLetters() {
        onView(withId(R.id.editN1)).perform(typeText("a"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithLetterAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithSpecialSymbols() {
        onView(withId(R.id.editN1)).perform(typeText("*"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun multiplicationButtonWithSpecialSymbolAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("9"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }
}