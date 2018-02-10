package com.example.jingyunyang.password_validator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JingyunYang on 2018/2/9.
 */

public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> myActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureNotPassword() {
        onView(withId(R.id.editTextInput)).perform(typeText("password"));//satisfy 2 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 2 rules,password is not strong!")));
    }

    @Test
    public void ensureLength() {
        onView(withId(R.id.editTextInput)).perform(typeText("Abcd134"));//satisfy 4 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 4 rules,password is not strong!")));
    }

    @Test
    public void ensureLowercase() {
        onView(withId(R.id.editTextInput)).perform(typeText("Abcd1234"));//satisfy 5 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 5 rules,password is strong!")));
    }

    @Test
    public void ensureUppercase() {
        onView(withId(R.id.editTextInput)).perform(typeText("ABCD124"));//satisfy 3 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 3 rules,password is not strong!")));
    }

    @Test
    public void ensureDigit() {
        onView(withId(R.id.editTextInput)).perform(typeText("12423412"));//satisfy 3 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 3 rules,password is not strong!")));
    }

    @Test
    public void ensureOther1() {
        onView(withId(R.id.editTextInput)).perform(typeText("122"));//satisfy 2 conditions
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 2 rules,password is not strong!")));
    }

    @Test
    public void ensureOther2() {
        onView(withId(R.id.editTextInput)).perform(typeText(":>"));//satisfy 1 condition
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.textViewerInfo)).check(matches(withText("Pass 1 rules,password is not strong!")));
    }

}
