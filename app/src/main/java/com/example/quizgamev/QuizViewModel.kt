package com.example.quizgamev

class QuizViewModel(private val repository: QuizRepository) {

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
                it.correct -> ChoiceUiState.Correct(it.value)
                text == it.value -> ChoiceUiState.Incorrect(it.value)
                else -> ChoiceUiState.NotChosen(it.value)
            }
        }
        return if (repository.isLastQuestion())
            UiState.Last(data.question, choices)
        else
            UiState.Answered(data.question, choices)
    }

    fun next(): UiState {
        return if (repository.isLastQuestion()) {
            UiState.GameOver
        } else {
            repository.next()
            init()
        }
    }
}