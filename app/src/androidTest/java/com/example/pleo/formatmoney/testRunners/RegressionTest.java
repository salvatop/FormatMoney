package com.example.pleo.formatmoney.testRunners;


import android.support.test.rule.ActivityTestRule;

import com.example.pleo.formatmoney.Main;
import com.example.pleo.formatmoney.StepDefinitions.RegressionTestSteps;
import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;

import static java.util.Locale.ENGLISH;

@RunWith(Parameterized.class)
    public class RegressionTest extends GreenCoffeeTest {
        @Rule
        public ActivityTestRule<Main> mActivityTestRule = new ActivityTestRule<>(Main.class);

        public RegressionTest(ScenarioConfig scenarioConfig) {
            super(scenarioConfig);
        }

        @Parameters(name = "{0}")
        public static Iterable<ScenarioConfig> scenarios() throws IOException {
            return new GreenCoffeeConfig()
                    .withFeatureFromAssets("assets/RegressionTest.feature")
                    .scenarios(ENGLISH);
        }

        @Test
        public void test() {
            start(new RegressionTestSteps());

        }
}
