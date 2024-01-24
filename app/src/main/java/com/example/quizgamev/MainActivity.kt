package com.example.quizgamev

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as ViewModelProviderFactory).viewModel(QuizViewModel::class.java)

        val questionTextView: TextView = findViewById(R.id.questionTextView)

        val choiceOneButton = findViewById<ChoiceButton>(R.id.choiceOneButton)
        val choiceTwoButton = findViewById<ChoiceButton>(R.id.choiceTwoButton)
        val choiceThreeButton = findViewById<ChoiceButton>(R.id.choiceThreeButton)
        val choiceFourButton = findViewById<ChoiceButton>(R.id.choiceFourButton)

        val actionButton = findViewById<Button>(R.id.actionButton)

        choiceOneButton.setOnClickListener {
            uiState = viewModel.choose(choiceOneButton.text.toString())
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
            uiState = viewModel.choose(choiceTwoButton.text.toString())
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
            uiState = viewModel.choose(choiceThreeButton.text.toString())
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
            uiState = viewModel.choose(choiceFourButton.text.toString())
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
            uiState = viewModel.next()
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, this)
        }

        if (savedInstanceState == null) {
            uiState = viewModel.init()
            uiState.show(questionTextView)
            uiState.show(choiceOneButton, choiceTwoButton, choiceThreeButton, choiceFourButton)
            uiState.show(actionButton, this)
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.save()
    }
}