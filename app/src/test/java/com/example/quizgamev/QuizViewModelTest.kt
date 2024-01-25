package com.example.quizgamev

import com.example.quizgamev.game.ChoiceUiState
import com.example.quizgamev.game.QuizViewModel
import com.example.quizgamev.game.UiState

import com.example.quizgamev.progress.QuizRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class QuizViewModelTest {

    @Test
    fun correctTwice() {
        val viewModel = QuizViewModel(repository = FakeRepository())

        var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Question(
            question = "question1",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "A"),
                ChoiceUiState.Question(text = "B"),
                ChoiceUiState.Question(text = "C"),
                ChoiceUiState.Question(text = "D"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("A")
        expected = UiState.Answered(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.Question(
            question = "question2",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "E"),
                ChoiceUiState.Question(text = "F"),
                ChoiceUiState.Question(text = "G"),
                ChoiceUiState.Question(text = "H"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("G")
        expected = UiState.Last(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.GameOver
        assertEquals(expected, actual)
    }

    @Test
    fun incorrectTwice() {
        val viewModel = QuizViewModel(repository = FakeRepository())

        var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Question(
            question = "question1",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "A"),
                ChoiceUiState.Question(text = "B"),
                ChoiceUiState.Question(text = "C"),
                ChoiceUiState.Question(text = "D"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("B")
        expected = UiState.Answered(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Correct,
                ChoiceUiState.Incorrect,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.Question(
            question = "question2",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "E"),
                ChoiceUiState.Question(text = "F"),
                ChoiceUiState.Question(text = "G"),
                ChoiceUiState.Question(text = "H"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("F")
        expected = UiState.Last(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.NotChosen,
                ChoiceUiState.Incorrect,
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.GameOver
        assertEquals(expected, actual)
    }

    @Test
    fun correctThenIncorrect() {
        val viewModel = QuizViewModel(repository = FakeRepository())

        var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Question(
            question = "question1",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "A"),
                ChoiceUiState.Question(text = "B"),
                ChoiceUiState.Question(text = "C"),
                ChoiceUiState.Question(text = "D"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("A")
        expected = UiState.Answered(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.Question(
            question = "question2",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "E"),
                ChoiceUiState.Question(text = "F"),
                ChoiceUiState.Question(text = "G"),
                ChoiceUiState.Question(text = "H"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("E")
        expected = UiState.Last(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Incorrect,
                ChoiceUiState.NotChosen,
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.GameOver
        assertEquals(expected, actual)
    }

    @Test
    fun incorrectThenCorrect() {
        val viewModel = QuizViewModel(repository = FakeRepository())

        var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Question(
            question = "question1",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "A"),
                ChoiceUiState.Question(text = "B"),
                ChoiceUiState.Question(text = "C"),
                ChoiceUiState.Question(text = "D"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("D")
        expected = UiState.Answered(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
                ChoiceUiState.Incorrect,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.Question(
            question = "question2",
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.Question(text = "E"),
                ChoiceUiState.Question(text = "F"),
                ChoiceUiState.Question(text = "G"),
                ChoiceUiState.Question(text = "H"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.choose("G")
        expected = UiState.Last(
            choices = listOf<ChoiceUiState>(
                ChoiceUiState.NotChosen,
                ChoiceUiState.NotChosen,
                ChoiceUiState.Correct,
                ChoiceUiState.NotChosen,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = UiState.GameOver
        assertEquals(expected, actual)
    }
}

private class FakeRepository : QuizRepository {

    private val list = listOf(
        QuestionAndChoices(
            question = "question1", choices = listOf(
                Choice(value = "A", correct = true),
                Choice(value = "B", correct = false),
                Choice(value = "C", correct = false),
                Choice(value = "D", correct = false)
            )
        ),
        QuestionAndChoices(
            question = "question2", choices = listOf(
                Choice(value = "E", correct = false),
                Choice(value = "F", correct = false),
                Choice(value = "G", correct = true),
                Choice(value = "H", correct = false)
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

    override fun finishGame() {

    }

    override fun save() {

    }
}