package com.example.quizgamev

import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf

class QuestionPage(
    private val question: String,
    private val choices: List<String>
) {

    fun checkQuestionVisible() {
        onView(
            allOf(
                withId(R.id.questionTextView),
                isAssignableFrom(TextView::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).check(matches(withText(question)))
    }

    fun checkAnswers() {
        choices.forEach { answer ->
            val answerView = onView(
                allOf(
                    withText(answer),
                    isAssignableFrom(AppCompatButton::class.java),
                    withParent(isAssignableFrom(LinearLayout::class.java)),
                    withParent(withId(R.id.rootLayout))
                )
            )
            answerView.check(matches(isDisplayed()))
            answerView.check(matches(ButtonColorMatcher(Color.parseColor("#7A84DA"))))
        }
    }

    fun clickAnswer(value: String) {
        onView(
            allOf(
                withText(value),
                isAssignableFrom(AppCompatButton::class.java),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout))
            )
        ).perform(click())
    }
}