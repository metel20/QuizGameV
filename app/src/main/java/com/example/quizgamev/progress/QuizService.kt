package com.example.quizgamev.progress

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizService {

    @GET("api.php")
    fun load(
        @Query("amount") amount: Int = 10,
        @Query("type") type: String = "multiple"
    ): Call<QuizResponse>
}

data class QuizResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val results: List<QuizResult>
)

data class QuizResult(
    @SerializedName("question")
    val question: String,
    @SerializedName("correct_answer")
    val answer: String,
    @SerializedName("incorrect_answers")
    val incorrectChoices: List<String>
)