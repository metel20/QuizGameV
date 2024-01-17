package com.example.quizgamev
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun correctTwice() {
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkChoicesNotAvailable(choices = list Of("yellow", "red", "blue"))
        answeredPage.clickChoice(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "white")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "red", "blue"))
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }

    @Test
    fun correctThenIncorrect() {
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkChoicesNotAvailable(choices = listOf("yellow", "red", "blue"))
        answeredPage.clickChoice(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "red")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkAnswerIncorrect(text = "red")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "blue"))
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }

    @Test
    fun incorrectTwice() {
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "yellow")

        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkAnswerIncorrect(text = "yellow")
        answeredPage.checkChoicesNotAvailable(choices = listOf("red", "blue"))
        answeredPage.clickChoice(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "blue")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkAnswerIncorrect(text = "blue")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "red", "blue"))
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }

    @Test
    fun incorrectThenCorrect() {
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "red")

        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkAnswerIncorrect(text = "red")
        answeredPage.checkChoicesNotAvailable(choices = listOf("yellow", "blue"))
        answeredPage.clickChoice(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoice(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "white")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "red", "blue"))
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }
}