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
        answeredPage.checkChoicesNotAvaliable(choices = listOf("yellow", "red", "blue"))
        answeredPage.clickChoise(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "white")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        answeredPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        gameOverPage.clickChoise(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }

    @Test
    fun correctThenIncorrect(){
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "green")


        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkChoicesNotAvaliable(choices = listOf("yellow", "red", "blue"))
        answeredPage.clickChoise(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "red")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        answeredPage.checkAnswerCorrect(text = "white")
        answeredPage.checkAnswerInCorrect(text = "red")
        gameOverPage.checkAnswers(answers = listOf("green", "white", "blue"))
        gameOverPage.clickChoise(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }
    @Test
    fun incorrectTwice(){
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "yellow")


        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkAnswerIncorrect(text = "yellow")
        answeredPage.checkChoicesNotAvaliable(choices = listOf("red", "blue"))
        answeredPage.clickChoise(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "blue")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        answeredPage.checkAnswerCorrect(text = "blue")
        gameOverPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        gameOverPage.clickChoise(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }
    @Test
    fun incorrectThenCorrect(){
        val questionPage = QuestionPage()
        questionPage.checkQuestionVisible(question = "What color is christmas tree?")
        questionPage.checkAnswers(answers = listOf("green", "yellow", "red", "blue"))
        questionPage.clickAnswer(value = "red")


        val answeredPage = AnsweredPage()
        answeredPage.checkVisible()
        answeredPage.checkQuestionVisible(question = "What color is christmas tree?")
        answeredPage.checkAnswerCorrect(text = "green")
        answeredPage.checkAnswerIncorrect(text = "red")
        answeredPage.checkChoicesNotAvaliable(choices = listOf("yellow", "red", "blue"))
        answeredPage.clickChoise(text = "yellow")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "red")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "blue")
        answeredPage.checkVisible()
        answeredPage.clickChoise(text = "green")
        answeredPage.checkVisible()
        answeredPage.clickNext()
        answeredPage.checkNotVisible()

        questionPage.checkQuestionVisible(question = "What color is milk?")
        questionPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        questionPage.clickAnswer(value = "white")

        val gameOverPage = GameOverPage()
        gameOverPage.checkVisible
        gameOverPage.checkQuestionVisible(question = "What color is milk?")
        answeredPage.checkAnswerCorrect(text = "white")
        gameOverPage.checkAnswers(answers = listOf("green", "white", "red", "blue"))
        gameOverPage.clickChoise(text = "green")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "white")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "red")
        gameOverPage.checkVisible()
        gameOverPage.clickChoise(text = "blue")
        gameOverPage.checkVisible()
        gameOverPage.clickGameOver()
        gameOverPage.checkNotVisible()
    }
}
