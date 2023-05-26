package com.example.triviaapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionAPI{

    @GET("/api.php")
    suspend fun getQuestions(
        @Query("amount") no_of_questions : String,
        @Query("category") category_of_questions: String,
        @Query("difficulty") difficulty_of_questions : String,
        @Query("type") type_of_questions : String

    ) : Response<QuestionResponse>

}