package com.example.quizgamev

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: QuizViewModel = QuizViewModel(QuizRepository.Base())

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val choiceOneButton = findViewById<Button>(R.id.choiceOneButton)
        val choiceTwoButton = findViewById<Button>(R.id.choiceTwoButton)
        val choiceThreeButton = findViewById<Button>(R.id.choiceThreeButton)
        val choiceFourButton = findViewById<Button>(R.id.choiceFourButton)
        val actionButton = findViewById<Button>(R.id.actionButton)

        choiceOneButton.setOnClickListener {
            val uiState: UiState = viewModel.choose(choiceOneButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }
        choiceTwoButton.setOnClickListener {
            val uiState: UiState = viewModel.choose(choiceTwoButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }
        choiceThreeButton.setOnClickListener {
            val uiState: UiState = viewModel.choose(choiceThreeButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }
        choiceFourButton.setOnClickListener {
            val uiState: UiState = viewModel.choose(choiceFourButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }
        actionButton.setOnClickListener {
            val uiState: UiState = viewModel.next()
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }

        val uiState: UiState = viewModel.init()
        uiState.show(questionTextView)
        uiState.show(choiceOneButton, choiceTwoButton, choiceThreeButton, choiceFourButton)
        uiState.show(actionButton, this)
    }
}