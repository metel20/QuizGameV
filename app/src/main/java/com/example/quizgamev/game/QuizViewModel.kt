package com.example.quizgamev.game

import androidx.lifecycle.ViewModel

class QuizViewModel(private val repository: GameRepository) : ViewModel() {

    fun init(): UiState {
        val data = repository.questionAndChoices()
        return UiState.Question(data.question, data.choices.map {
            ChoiceUiState.Question(it.value)
        })
    }

    fun choose(text: String): UiState {
        val data = repository.questionAndChoices()
        val choices = data.choices.map {
            when {
                it.correct -> ChoiceUiState.Correct
                text == it.value -> ChoiceUiState.Incorrect
                else -> ChoiceUiState.NotChosen
            }
        }
        return if (repository.isLastQuestion())
            UiState.Last(choices)
        else
            UiState.Answered(choices)
    }

    fun next(): UiState {
        return if (repository.isLastQuestion()) {
            repository.finishGame()
            UiState.GameOver
        } else {
            repository.next()
            init()
        }
    }

    fun save() {
        repository.save()
    }
}