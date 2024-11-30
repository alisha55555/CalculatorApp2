package com.example.calculatorapp2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CalculatorUiTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void additionTest() {
        // Нажать на кнопку "2"
        Espresso.onView(ViewMatchers.withId(R.id.btn_2)).perform(ViewActions.click());
        // Нажать на кнопку "+"
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click());
        // Нажать на кнопку "3"
        Espresso.onView(ViewMatchers.withId(R.id.btn_3)).perform(ViewActions.click());
        // Нажать на кнопку "="
        Espresso.onView(ViewMatchers.withId(R.id.btn_equals)).perform(ViewActions.click());
        // Проверить, что результат содержит "5"
        Espresso.onView(ViewMatchers.withId(R.id.editText))
                .check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("5"))));
    }
}
