package com.example.quizgamev

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class ButtonColorMatcher(private val color: Int) :
    BoundedMatcher<View, Button>(Button::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("color for button")
    }

    override fun matchesSafely(item: Button): Boolean {
        return (item.background as ColorDrawable).color == color
    }
}