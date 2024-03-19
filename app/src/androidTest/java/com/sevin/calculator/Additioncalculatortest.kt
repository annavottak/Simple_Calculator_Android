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

class Additioncalculatortest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun additionButtonWithoutNumber() {
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
        onView(withId(R.id.result)).check(matches(withText("Result: 10.0")))
    }
    @Test
    fun additionButtonWithLetters() {
        onView(withId(R.id.editN1)).perform(typeText("a"), closeSoftKeyboard())
        onView(withId(R.id.editN2)).perform(typeText("s"), closeSoftKeyboard())
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("Enter Number!")))
    }
}