package com.example.pleo.formatmoney.testRunners;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.pleo.formatmoney.Main;
import com.example.pleo.formatmoney.R;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class EndToEndTest {

    @Rule
    public ActivityTestRule<Main> mActivityTestRule = new ActivityTestRule<>(Main.class);

    @Test
    public void runTestSession() {

        ViewInteraction inputBox = onView(Matchers.allOf(ViewMatchers.withId(R.id.inputBox), isDisplayed()));
        inputBox.perform(click());

        inputBox.perform(replaceText("1600"), closeSoftKeyboard());

        ViewInteraction formatButton = onView(Matchers.allOf(withId(R.id.submit), withText("Format"), isDisplayed()));
        formatButton.perform(click());

        ViewInteraction resultsOutput = onView(Matchers.allOf(withId(R.id.displayResults), isDisplayed()));
        resultsOutput.check(matches(withText("The formatted amount is: 1 600.00")));

        inputBox.perform(replaceText(""),closeSoftKeyboard());
    }
}