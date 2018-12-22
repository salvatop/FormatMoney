package com.example.pleo.formatmoney.StepDefinitions;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.pleo.formatmoney.Main;
import com.example.pleo.formatmoney.R;
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import org.hamcrest.Matchers;
import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class RegressionTestSteps extends GreenCoffeeSteps {

    @Rule
    public ActivityTestRule<Main> mActivityTestRule = new ActivityTestRule<>(Main.class);

    @Given("^I see an empty input form$")
    public void inputFormIsReady() {
        onViewWithId(R.id.inputBox).isEmpty();
    }

    @When("^I input the valid(.+)$")
    public void inputValidAmount(String validAmount) {
        onViewWithId(R.id.inputBox).type(validAmount);
    }

    @When("^I input the invalid(.+)$")
    public void inputInvalidAmount(String invalidAmount) {
        onViewWithId(R.id.inputBox).type(invalidAmount);
    }

    @When("^I press the format button$")
    public void clickOnFormatButton() {
        onViewWithId(R.id.submit).click();
    }

    @When("^I clear the input form$")
    public void clearForm() {
        ViewInteraction inputBox = onView(Matchers.allOf(ViewMatchers.withId(R.id.inputBox)));
        inputBox.perform(replaceText(""), closeSoftKeyboard());
    }

    @Then("^I should see the output message that contains(.+)$")
    public void showResults(String output) {
    ViewInteraction resultsOutput = onView(Matchers.allOf(withId(R.id.displayResults), isDisplayed()));
        resultsOutput.toString().contains(output);
    }

    @Then("^I should see the output message that contains 'Only number are allowed'$")
    public void outputErrorMessage() {
        onViewWithText(R.string.onlyNumbersAllowed).isDisplayed();
    }
}
