package com.orange.ease.dan;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.orange.ease.dan.R.array.criteria_alt_list;
import static com.orange.ease.dan.R.array.criteria_clickarea_list;
import static com.orange.ease.dan.R.array.criteria_color_list;
import static com.orange.ease.dan.R.array.criteria_contentchange_list;
import static com.orange.ease.dan.R.array.criteria_contentcontrol_list;
import static com.orange.ease.dan.R.array.criteria_focusnav_list;
import static com.orange.ease.dan.R.array.criteria_form_list;
import static com.orange.ease.dan.R.array.criteria_ghostelement_list;
import static com.orange.ease.dan.R.array.criteria_img_list;
import static com.orange.ease.dan.R.array.criteria_list;
import static com.orange.ease.dan.R.array.criteria_readorder_list;
import static com.orange.ease.dan.R.array.criteria_scroll_list;
import static com.orange.ease.dan.R.array.criteria_stateelement_list;
import static com.orange.ease.dan.R.array.criteria_textsize_list;
import static com.orange.ease.dan.R.array.criteria_title_list;
import static com.orange.ease.dan.R.array.dev_list;
import static com.orange.ease.dan.R.array.options_list;
import static com.orange.ease.dan.R.id.buttonOptionsAxs;
import static com.orange.ease.dan.R.string.alert_before_leaving;
import static com.orange.ease.dan.R.string.tb_moves_btn;
import static com.orange.ease.dan.R.string.tb_tuto_close;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

    private String[] getResourceStringArray(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getStringArray(id);
    }

    @BeforeClass
    public static void enableAccessibilityChecks() {
        // AccessibilityChecks.enable().setRunChecksFromRootView(true).setSuppressingResultMatcher(AccessibilityCheckResultUtils.matchesViews(withId(-1)));;
        // AccessibilityChecks.enable();
    }

    @Rule
    public ActivityTestRule<MainActivity_> mActivityTestRule = new ActivityTestRule<>(MainActivity_.class);


    @Test
    public void test_dev_guide() {
        onView(withId(R.id.home_dev_button)).perform(click());
        navigateOnEveryItemOfAStringAdapterList(dev_list);
    }

    @Test
    public void test_talkback() {
        onView(withId(R.id.home_talkback_button)).perform(click());

        onView(allOf(withId(R.id.buttonGesture), withText(tb_moves_btn))).perform(scrollTo(), click());

        for (int i = 0; i < 12; i++) {
            onView(withId(R.id.buttonNext)).perform(click());
        }
        onView(withId(R.id.buttonPrevious)).perform(click());
        onView(allOf(withContentDescription(tb_tuto_close), withParent(withId(R.id.my_toolbar)), isDisplayed())).perform(click());
    }

    @Test
    public void test_acc_options() {
        onView(withId(R.id.home_options_button)).perform(click());
        navigateOnEveryItemOfAStringAdapterList(options_list);
        onView(withId(buttonOptionsAxs)).perform(click());
        onView(withText(alert_before_leaving)).inRoot(isDialog()) // <---
                .check(matches(isDisplayed()))
                .perform(click());

    }


    @Test
    public void test_accessibility_guide() {

        //guide d'accessibilité
        onView(withId(R.id.home_criteria_button)).perform(click());

        String[] criteriaList = getResourceStringArray(criteria_list);

        //construct map with sub lists
        LinkedHashMap<String, Integer> listStructure = new LinkedHashMap<>();
        listStructure.put(criteriaList[0], criteria_img_list);
        listStructure.put(criteriaList[1], criteria_color_list);
        listStructure.put(criteriaList[2], criteria_alt_list);
        listStructure.put(criteriaList[3], criteria_title_list);
        listStructure.put(criteriaList[4], criteria_stateelement_list);
        //listStructure.put(criteriaList[5],criteria_stateelement_list);
        listStructure.put(criteriaList[6], criteria_clickarea_list);
        listStructure.put(criteriaList[7], criteria_ghostelement_list);
        listStructure.put(criteriaList[8], criteria_textsize_list);
        listStructure.put(criteriaList[9], criteria_contentcontrol_list);
        listStructure.put(criteriaList[10], criteria_contentchange_list);
        listStructure.put(criteriaList[11], criteria_scroll_list);
        listStructure.put(criteriaList[12], criteria_form_list);
        listStructure.put(criteriaList[13], criteria_readorder_list);
        listStructure.put(criteriaList[14], criteria_focusnav_list);

        for (String firstLevelItem : listStructure.keySet()) {
            System.out.println("Browsing " + firstLevelItem);
            onData(allOf(is(instanceOf(String.class)), equalTo(firstLevelItem))).perform(click());
            navigateOnEveryItemOfAStringAdapterList(listStructure.get(firstLevelItem));
            pressBack();
        }
    }


    private void navigateOnEveryItemOfAStringAdapterList(int stringArrayResourceId) {
        String[] colorCriteria = getResourceStringArray(stringArrayResourceId);
        for (int i = 0; i < colorCriteria.length; i++) {
            System.out.println("- sub level " + colorCriteria[i]);
            onData(allOf(is(instanceOf(String.class)), equalTo(colorCriteria[i]))).perform(click());
            clickOnVoiceOverPopupIfNeeded();
            pressBack();
        }
    }


    private void clickOnVoiceOverPopupIfNeeded() {
        try {
            onView(withId(R.id.choice)).check(matches(isDisplayed())).perform(click());
            onView(withId(R.id.close)).check(matches(isDisplayed())).perform(click());
            //view is displayed logic
        } catch (NoMatchingViewException e) {
            System.out.println("No popup " + e.toString());
            //view not displayed logic
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}