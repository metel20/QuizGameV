package com.example.quizgamev.main

import androidx.lifecycle.ViewModel
import com.example.quizgamev.game.GameScreen
import com.example.quizgamev.progress.LoadScreen

class MainViewModel(
    private val screenRepository: ScreenRepository.Read
) : ViewModel() {

    fun screen(): Screen = if (screenRepository.shouldLoadNewGame())
        LoadScreen
    else
        GameScreen
}