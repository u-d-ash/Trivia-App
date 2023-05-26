package com.example.triviaapp

data class QuestionResponse(
    val response_code: Int,
    val results: List<Question>
)