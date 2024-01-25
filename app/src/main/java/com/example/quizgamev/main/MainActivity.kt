package com.example.quizgamev.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizgamev.R
import com.example.quizgamev.ViewModelProviderFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel =
            (application as ViewModelProviderFactory).viewModel(MainViewModel::class.java)

        if (savedInstanceState == null) {
            val screen = viewModel.screen()
            screen.show(R.id.container, supportFragmentManager)
        }
    }
}