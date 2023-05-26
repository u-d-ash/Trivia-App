package com.example.triviaapp

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    companion object{
        val quesList : List<Question> = emptyList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val sportsButton = findViewById<ImageView>(R.id.sports_new_game_button)
        val gkButton = findViewById<ImageView>(R.id.GK_new_game_button)
        val enterButton = findViewById<ImageView>(R.id.entertainment_new_game_button)
        val sciButton = findViewById<ImageView>(R.id.science_new_game_button)

        val udash = findViewById<TextView>(R.id.createdByUdit)

        sportsButton.setOnClickListener{
            val intent = Intent(this, QuizsetterActivity::class.java)
            intent.putExtra("category", "Sports")
            startActivity(intent)
        }
        gkButton.setOnClickListener{
            val intent = Intent(this, QuizsetterActivity::class.java)
            intent.putExtra("category", "General Knowledge")
            startActivity(intent)
        }
        enterButton.setOnClickListener{
            val intent = Intent(this, QuizsetterActivity::class.java)
            intent.putExtra("category", "Entertainment")
            startActivity(intent)
        }
        sciButton.setOnClickListener{
            val intent = Intent(this, QuizsetterActivity::class.java)
            intent.putExtra("category", "Science")
            startActivity(intent)
        }

        udash.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/u_d_ash_/?next=/")
            startActivity(openURL)
        }

    }
}

class singletonClass private constructor() {
    var data: List<Question>? = null
    companion object {
        val instance = singletonClass()
    }
}