package com.example.quizgamev
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun correctTwice() {
        var questionPage = QuestionPage(
            question = "What color is christmas tree?",
            choices = listOf("green", "yellow", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        activityScenarioRule.scenario.recreate()
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage(question = "What color is christmas tree?")
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible()
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkChoicesNotAvailable(choices = listOf("yellow", "red", "blue"))
        activityScenarioRule.scenario.recreate()
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

        questionPage = QuestionPage(
            question = "What color is milk?",
            choices = listOf("green", "white", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        activityScenarioRule.scenario.recreate()
        questionPage.clickAnswer(value = "white")

        val gameOverPage = GameOverPage(question = "What color is milk?")
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible()
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "red", "blue"))
        activityScenarioRule.scenario.recreate()
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        assertTrue(activityScenarioRule.scenario.state != Lifecycle.State.RESUMED)
    }

    @Test
    fun correctThenIncorrect() {
        var questionPage = QuestionPage(
            question = "What color is christmas tree?",
            choices = listOf("green", "yellow", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage(question = "What color is christmas tree?")
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible()
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

        questionPage = QuestionPage(
            question = "What color is milk?",
            choices = listOf("green", "white", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "red")

        val gameOverPage = GameOverPage(question = "What color is milk?")
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible()
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
        assertTrue(activityScenarioRule.scenario.state != Lifecycle.State.RESUMED)
    }

    @Test
    fun incorrectTwice() {
        var questionPage = QuestionPage(
            question = "What color is christmas tree?",
            choices = listOf("green", "yellow", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage(question = "What color is christmas tree?")
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible()
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

        questionPage = QuestionPage(
            question = "What color is milk?",
            choices = listOf("green", "white", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "red")

        val gameOverPage = GameOverPage(question = "What color is milk?")
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible()
        gameOverPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkAnswerIncorrect(text = "blue")
        gameOverPage.checkChoicesNotAvailable(choices = listOf("green", "red"))
        gameOverPage.clickChoice(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickChoice(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        assertTrue(activityScenarioRule.scenario.state != Lifecycle.State.RESUMED)
    }

    @Test
    fun incorrectThenCorrect() {
        var questionPage = QuestionPage(
            question = "What color is christmas tree?",
            choices = listOf("green", "yellow", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "green")

        val answeredPage = AnsweredPage(question = "What color is christmas tree?")
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible()
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

        questionPage = QuestionPage(
            question = "What color is milk?",
            choices = listOf("green", "white", "red", "blue")
        )
        questionPage.checkQuestionVisible()
        questionPage.checkAnswers()
        questionPage.clickAnswer(value = "red")

        val gameOverPage = GameOverPage(question = "What color is milk?")
        gameOverPage.checkVisible()
        gameOverPage.checkQuestionVisible()
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
        assertTrue(activityScenarioRule.scenario.state != Lifecycle.State.RESUMED)
    }
}