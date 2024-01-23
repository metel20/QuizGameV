package com.example.quizgamev

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel

class QuizApplication : Application(), ViewModelProviderFactory {

    private lateinit var factory: ViewModelProviderFactory

    override fun onCreate() {
        super.onCreate()
        factory = ViewModelProviderFactory.Base(BuildConfig.DEBUG, this)
    }

    override fun <T : ViewModel> viewModel(clasz: Class<out T>): T {
        return factory.viewModel(clasz)
    }
}

interface ViewModelProviderFactory {

    fun <T : ViewModel> viewModel(clasz: Class<out T>): T

    class Base(
        private val isRelease: Boolean,
        private val context: Context
    ) : ViewModelProviderFactory {

        private val viewModelStore = HashMap<Class<*>, ViewModel>()

        override fun <T : ViewModel> viewModel(clasz: Class<out T>): T {
            return if (viewModelStore.containsKey(clasz))
                viewModelStore[clasz] as T
            else {
                val vm = when (clasz) {
                    QuizViewModel::class.java -> QuizViewModel(
                        QuizRepository.Base(
                            if (isRelease)
                                PermanentStorage.Base(
                                    context
                                )
                            else
                                PermanentStorage.Mock()
                        )
                    )

                    else -> throw IllegalStateException("unknown")
                } as T
                viewModelStore[clasz] = vm
                vm
            }
        }
    }
}
