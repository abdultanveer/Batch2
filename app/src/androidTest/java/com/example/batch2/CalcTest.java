package com.example.batch2;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalcTest {

    @Rule
    public ActivityTestRule<CalculatorActivity> mActivityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void loginTest() {
        String mStringToBetyped = "thanks";
        // 1. Find view by Id
        onView(withId(R.id.editTextfirst))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.buttonDialer)).perform(click());
        onView(withId(R.id.textViewSalution))
                .check(matches(withText(mStringToBetyped)));


    }
}
