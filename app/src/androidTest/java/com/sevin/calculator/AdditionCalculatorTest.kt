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

class AdditionCalculatorTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun additionButtonWithoutNumbers() {
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithoutSecondNumber() {
        onView(withId(R.id.editN2)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithoutFirstNumber() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithPositiveNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("13"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 38.0")))
    }

    @Test
    fun additionButtonWithMixNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 12.0")))
    }

    @Test
    fun additionButtonWithNegativeNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("-25"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("-13"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: -38.0")))
    }

    @Test
    fun additionButtonNullNumbers() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 0.0")))
    }

    @Test
    fun additionButtonWithNullNumber() {
        onView(withId(R.id.editN1)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Result: 1.0")))
    }

    @Test
    fun additionButtonWithLetters() {
        onView(withId(R.id.editN1)).perform(typeText("a"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithLetterAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithSpecialSymbols() {
        onView(withId(R.id.editN1)).perform(typeText("*"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }

    @Test
    fun additionButtonWithSpecialSymbolAndNumber() {
        onView(withId(R.id.editN1)).perform(typeText("9"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("+"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }
}