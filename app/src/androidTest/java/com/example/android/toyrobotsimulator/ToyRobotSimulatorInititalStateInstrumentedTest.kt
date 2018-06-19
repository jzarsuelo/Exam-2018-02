package com.example.android.toyrobotsimulator

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isEnabled
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ToyRobotSimulatorInititalStateInstrumentedTest {

    @Rule @JvmField var testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun buttonsInitialState() {
        onView(withId(R.id.placeButton)).check(matches(isEnabled()))
        onView(withId(R.id.moveButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.rightButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.leftButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.reportButton)).check(matches(not(isEnabled())))
    }

    @Test
    fun initialCoordinates_Incorrect_X() {
        onView(withId(R.id.xCoordinateEditText)).perform(typeText("7"))
        onView(withId(R.id.yCoordinateEditText)).perform(typeText("4"))
        onView(withId(R.id.placeButton)).perform(click())

        onView(withId(R.id.moveButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.rightButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.leftButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.reportButton)).check(matches(not(isEnabled())))
    }

    @Test
    fun initialCoordinates_Incorrect_Y() {
        onView(withId(R.id.xCoordinateEditText)).perform(typeText("0"))
        onView(withId(R.id.yCoordinateEditText)).perform(typeText("9"))
        onView(withId(R.id.placeButton)).perform(click())

        onView(withId(R.id.moveButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.rightButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.leftButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.reportButton)).check(matches(not(isEnabled())))
    }

    @Test
    fun initialCoordinates_Correct() {
        onView(withId(R.id.xCoordinateEditText)).perform(typeText("0"))
        onView(withId(R.id.yCoordinateEditText)).perform(typeText("0"))
        onView(withId(R.id.placeButton)).perform(click())

        onView(withId(R.id.moveButton)).check(matches(isEnabled()))
        onView(withId(R.id.rightButton)).check(matches(isEnabled()))
        onView(withId(R.id.leftButton)).check(matches(isEnabled()))
        onView(withId(R.id.reportButton)).check(matches(isEnabled()))
    }

}
