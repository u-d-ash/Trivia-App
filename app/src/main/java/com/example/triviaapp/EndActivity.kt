package com.example.triviaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EndActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        supportActionBar?.hide()

        val bundle = intent.extras

        var points = 0
        var ques = 0

        if(bundle != null){
            points = bundle.getInt("current points")
            ques = bundle.getInt("total_quest")
        }

        val score : TextView = findViewById(R.id.score_fraction_tv)

        score.text = "${points}/${ques}"

    }

    override fun onBackPressed() {
        val startIntent = Intent(this, MainActivity::class.java)
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.startActivity(startIntent)
    }
}