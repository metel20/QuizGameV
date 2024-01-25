package com.example.quizgamev.progress

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quizgamev.R
import com.example.quizgamev.ViewModelProviderFactory

class LoadFragment : Fragment(R.layout.fragment_load) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel =
            (requireActivity().application as ViewModelProviderFactory).viewModel(LoadViewModel::class.java)

        val retryButton = view.findViewById<Button>(R.id.retryButton)
        val errorTextView = view.findViewById<TextView>(R.id.errorTextView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        retryButton.setOnClickListener {
            viewModel.load()
        }

        if (savedInstanceState == null) {
            viewModel.load()
        }
    }
}