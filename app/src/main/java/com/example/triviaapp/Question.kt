package com.example.triviaapp

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String
)