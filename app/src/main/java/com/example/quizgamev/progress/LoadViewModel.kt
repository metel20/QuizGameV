package com.example.quizgamev.progress

import androidx.lifecycle.ViewModel

class LoadViewModel(
    private val repository: QuizRepository
) : ViewModel() {

    private val callback = object : LoadCallback {
        override fun loadedSuccessfully() {
            //todo navigate to next screen
        }

        override fun loadError(error: String) {
            println("error $error")
        }
    }

    fun load() {
        repository.loadData(callback)
        println()
    }
}