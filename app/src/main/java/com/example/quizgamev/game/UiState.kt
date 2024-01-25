package com.example.quizgamev.game

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.quizgamev.R
import java.io.Serializable

interface UiState : Serializable {

    fun show(questionTextView: TextView)
    fun show(vararg choices: ChoiceButton)
    fun show(actionButton: Button, activity: FragmentActivity)

    data class Question(
        private val question: String,
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
            questionTextView.text = question
        }

        override fun show(vararg choices: ChoiceButton) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choices[index].updateState(choiceUiState)
            }
        }

        override fun show(actionButton: Button, activity: FragmentActivity) {
            actionButton.visibility = View.GONE
        }
    }

    data class Answered(
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
        }

        override fun show(vararg choices: ChoiceButton) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choices[index].updateState(choiceUiState)
            }
        }

        override fun show(actionButton: Button, activity: FragmentActivity) = with(actionButton) {
            visibility = View.VISIBLE
            setBackgroundColor(Color.parseColor("#6AD9E8"))
        }
    }

    data class Last(
        private val choices: List<ChoiceUiState>
    ) : UiState {

        override fun show(questionTextView: TextView) {
        }

        override fun show(vararg choices: ChoiceButton) {
            this.choices.forEachIndexed { index, choiceUiState ->
                choices[index].updateState(choiceUiState)
            }
        }

        override fun show(actionButton: Button, activity: FragmentActivity) = with(actionButton) {
            visibility = View.VISIBLE
            setText(R.string.game_over)
            setBackgroundColor(Color.parseColor("#6AD9E8"))
        }
    }

    object GameOver : UiState {

        override fun show(questionTextView: TextView) = Unit

        override fun show(vararg choices: ChoiceButton) = Unit

        override fun show(actionButton: Button, activity: FragmentActivity) =
            activity.finish()//todo go to fragment load
    }
}

interface ChoiceUiState : Serializable {

    fun show(button: ChoiceButton)

    object Empty : ChoiceUiState {
        override fun show(button: ChoiceButton) = Unit
    }

    abstract class Abstract(
        private val color: String,
        private val clickable: Boolean = false
    ) : ChoiceUiState {

        override fun show(button: ChoiceButton) {
            button.setBackgroundColor(Color.parseColor(color))
            button.isClickable = clickable
        }
    }

    data class Question(private val text: String) : Abstract("#7A84DA", true) {

        override fun show(button: ChoiceButton) {
            super.show(button)
            button.text = text
        }
    }

    object Correct : Abstract("#80E38A")

    object Incorrect : Abstract("#E63B3B")

    object NotChosen : Abstract("#6E7292")
}