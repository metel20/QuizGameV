package com.example.quizgamev.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quizgamev.R
import com.example.quizgamev.ViewModelProviderFactory


class GameFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            (requireActivity().application as ViewModelProviderFactory).viewModel(QuizViewModel::class.java)

        val questionTextView: TextView = view.findViewById(R.id.questionTextView)

        val choiceOneButton = view.findViewById<ChoiceButton>(R.id.choiceOneButton)
        val choiceTwoButton = view.findViewById<ChoiceButton>(R.id.choiceTwoButton)
        val choiceThreeButton = view.findViewById<ChoiceButton>(R.id.choiceThreeButton)
        val choiceFourButton = view.findViewById<ChoiceButton>(R.id.choiceFourButton)

        val actionButton = view.findViewById<Button>(R.id.actionButton)

        choiceOneButton.setOnClickListener {
            val uiState = viewModel.choose(choiceOneButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, requireActivity())
        }
        choiceTwoButton.setOnClickListener {
            val uiState = viewModel.choose(choiceTwoButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, requireActivity())
        }
        choiceThreeButton.setOnClickListener {
            val uiState = viewModel.choose(choiceThreeButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, requireActivity())
        }
        choiceFourButton.setOnClickListener {
            val uiState = viewModel.choose(choiceFourButton.text.toString())
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, requireActivity())
        }
        actionButton.setOnClickListener {
            val uiState = viewModel.next()
            uiState.show(questionTextView)
            uiState.show(
                choiceOneButton,
                choiceTwoButton,
                choiceThreeButton,
                choiceFourButton
            )
            uiState.show(actionButton, requireActivity())
        }

        if (savedInstanceState == null) {
            val uiState = viewModel.init()
            uiState.show(questionTextView)
            uiState.show(choiceOneButton, choiceTwoButton, choiceThreeButton, choiceFourButton)
            uiState.show(actionButton, requireActivity())
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.save()
    }
}