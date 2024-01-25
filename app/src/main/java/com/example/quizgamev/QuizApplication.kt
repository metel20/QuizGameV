package com.example.quizgamev

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quizgamev.game.GameRepository
import com.example.quizgamev.game.PermanentStorage
import com.example.quizgamev.game.QuizViewModel
import com.example.quizgamev.main.LocalStorage
import com.example.quizgamev.main.MainViewModel
import com.example.quizgamev.main.ScreenRepository
import com.example.quizgamev.progress.LoadViewModel
import com.example.quizgamev.progress.QuizCacheDataSource
import com.example.quizgamev.progress.QuizRepository
import com.example.quizgamev.progress.QuizService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
        context: Context
    ) : ViewModelProviderFactory {

        private val viewModelStore = HashMap<Class<*>, ViewModel>()

        private val localStorage = LocalStorage.Base(context)
        private val quizCacheDataSource: QuizCacheDataSource.Mutable = QuizCacheDataSource.Base(
            Gson(), localStorage
        )
        private val screenRepository = ScreenRepository.Base(localStorage)

        override fun <T : ViewModel> viewModel(clasz: Class<out T>): T {
            return if (viewModelStore.containsKey(clasz))
                viewModelStore[clasz] as T
            else {
                val vm = when (clasz) {
                    MainViewModel::class.java -> {
                        MainViewModel(screenRepository)
                    }

                    LoadViewModel::class.java -> {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        val client: OkHttpClient = OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build()

                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://opentdb.com/")
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                        LoadViewModel(
                            QuizRepository.Base(
                                quizCacheDataSource,
                                screenRepository,
                                retrofit.create(QuizService::class.java)
                            )
                        )
                    }

                    QuizViewModel::class.java -> QuizViewModel(
                        GameRepository.Base(
                            quizCacheDataSource,
                            PermanentStorage.Base(localStorage)
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
