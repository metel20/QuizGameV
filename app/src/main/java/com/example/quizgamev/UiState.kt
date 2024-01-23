package com.example.quizgamev

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun show(questionTextView: TextView)
    fun show(vararg choices: Button)
    fun show(actionButton: Button, activity: MainActivity)

    data class Question(
        private val question: String,
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
            questionTextView.text = question
        }

        override fun show(vararg choices: Button) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choiceUiState.show(choices[index])
            }
        }

        override fun show(actionButton: Button, activity: MainActivity) {
            actionButton.visibility = View.GONE
        }
    }

    data class Answered(
        private val question: String,
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
            questionTextView.text = question
        }

        override fun show(vararg choices: Button) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choiceUiState.show(choices[index])
            }
        }

        override fun show(actionButton: Button, activity: MainActivity) = with(actionButton) {
            visibility = View.VISIBLE
            setText(R.string.next)
            setBackgroundColor(Color.parseColor("#6AD9E8"))
        }
    }

    data class Last(
        private val question: String,
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
            questionTextView.text = question
        }

        override fun show(vararg choices: Button) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choiceUiState.show(choices[index])
            }
        }

        override fun show(actionButton: Button, activity: MainActivity) = with(actionButton) {
            visibility = View.VISIBLE
            setText(R.string.game_over)
            setBackgroundColor(Color.parseColor("#6AD9E8"))
        }
    }

    object GameOver : UiState {

        override fun show(questionTextView: TextView) = Unit

        override fun show(vararg choices: Button) = Unit

        override fun show(actionButton: Button, activity: MainActivity) = activity.finish()
    }
}

interface ChoiceUiState {

    fun show(button: Button)

    abstract class Abstract(
        private val value: String,
        private val color: String,
        private val clickable: Boolean = false,
    ) : ChoiceUiState {

        override fun show(button: Button) = with(button) {
            isClickable = clickable
            text = value
            setBackgroundColor(Color.parseColor(color))
        }
    }

    data class Question(private val text: String) : Abstract(text, "#7A84DA", true)

    data class Correct(private val text: String) : Abstract(text, "#80E38A")

    data class Incorrect(private val text: String) : Abstract(text, "#E63B3B")

    data class NotChosen(private val text: String) : Abstract(text, "#6E7292")
}