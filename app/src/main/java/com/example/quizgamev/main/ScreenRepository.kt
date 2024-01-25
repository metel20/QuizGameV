package com.example.quizgamev.main

interface ScreenRepository {

    interface Read {
        fun shouldLoadNewGame(): Boolean
    }

    interface Save {
        fun saveGameAlreadyStarted()
        fun saveShouldLoadNewGame()
    }

    interface Mutable : Save, Read

    class Base(private val localStorage: LocalStorage) : Mutable {

        override fun saveGameAlreadyStarted() {
            localStorage.save(false, KEY)
        }

        override fun saveShouldLoadNewGame() {
            localStorage.save(true, KEY)
        }

        override fun shouldLoadNewGame(): Boolean {
            return localStorage.read(KEY, true)
        }

        companion object {
            private const val KEY = "shouldLoadNewGame"
        }
    }
}