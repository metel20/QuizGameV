package com.example.quizgamev
interface QuizRepository {

    fun next()

    fun questionAndChoices(): QuestionAndChoices

    fun isLastQuestion(): Boolean

    class Base : QuizRepository {//todo replace questions and choices

        private val list = listOf(
            QuestionAndChoices(
                question = "What color is christmas tree?", choices = listOf(
                    Choice(value = "green", correct = true),
                    Choice(value = "yellow", correct = false),
                    Choice(value = "red", correct = false),
                    Choice(value = "blue", correct = false)
                )
            ),
            QuestionAndChoices(
                question = "What color is milk?", choices = listOf(
                    Choice(value = "green", correct = false),
                    Choice(value = "white", correct = true),
                    Choice(value = "red", correct = false),
                    Choice(value = "blue", correct = false)
                )
            )
        )

        private var index = 0

        override fun next() {
            index++
        }

        override fun questionAndChoices(): QuestionAndChoices {
            return list[index]
        }

        override fun isLastQuestion(): Boolean {
            return index == list.size - 1
        }

    }
}

data class QuestionAndChoices(val question: String, val choices: List<Choice>)

data class Choice(val value: String, val correct: Boolean)