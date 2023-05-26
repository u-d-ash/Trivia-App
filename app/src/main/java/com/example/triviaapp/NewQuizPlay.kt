package com.example.triviaapp

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import kotlinx.coroutines.NonCancellable.cancel
import kotlin.random.Random

class NewQuizPlay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val bundle = intent.extras

        var x = 0
        var cp = 0
        var tq = 0

        if(bundle != null){
            x = bundle.getInt("code")
            cp = bundle.getInt("current points")
            tq = bundle.getInt("total_questions")
        }

        if(x == 0){
            var total_quest = 0
            var position = 0

            var points = 0

            if(bundle != null){
                total_quest = bundle.getInt("total_questions")
            }

            val data = singletonClass.instance.data


            setContentView(R.layout.new_quiz_play)

            val questionTextView : TextView = findViewById(R.id.question_text)
            val option1 = findViewById<Button>(R.id.option1)
            val option2 = findViewById<Button>(R.id.option2)
            val option3 = findViewById<Button>(R.id.option3)
            val option4 = findViewById<Button>(R.id.option4)
            val questionNo = findViewById<TextView>(R.id.question_no_tv)

            var cor = 0
            if(data != null){

                //HtmlCompat.fromHtml(ans, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
                questionTextView.text = HtmlCompat.fromHtml(data[position].question, HtmlCompat.FROM_HTML_MODE_LEGACY)
                questionNo.text = "${position + 1}."

                val randVal = Random.nextInt(0, 4)

                if(randVal == 1){
                    cor = 1
                    option1.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else if(randVal == 2){
                    cor = 2
                    option2.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else if(randVal == 3){
                    cor = 3
                    option3.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else{
                    cor = 4
                    option4.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }
            }

            val intent = Intent(this, NewQuizPlay::class.java)
            position++
            Log.e("Position@Init", position.toString())
            intent.putExtra("code", 1)
            intent.putExtra("position", position)
            intent.putExtra("total_quest", total_quest)

            option1.setOnClickListener {
                if(cor == 1){
                    points += 1
                    Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }else{
                    Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)

                }


            }
            option2.setOnClickListener {
                if(cor == 2){
                    points += 1
                    Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }else{
                    Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }

            }
            option3.setOnClickListener {
                if(cor == 3){
                    points += 1
                    Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }else{
                    Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }

            }
            option4.setOnClickListener {
                if(cor == 4){
                    points += 1
                    Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }else{
                    Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                    val handler  = Handler()
                    handler.postDelayed(Runnable { intent.putExtra("current points", points)
                        startActivity(intent) }, 2000)
                }

            }


        }else if(x == 1){
            var position = 0
            var totalQ = 0
            var points = 0

            val data = singletonClass.instance.data

            var cor = 0

            if(bundle != null){
                position = bundle.getInt("position")
                points = bundle.getInt("current points")
                totalQ = bundle.getInt("total_quest")

            }





            setContentView(R.layout.new_quiz_play)

            val questionTextView : TextView = findViewById(R.id.question_text)
            val option1 = findViewById<Button>(R.id.option1)
            val option2 = findViewById<Button>(R.id.option2)
            val option3 = findViewById<Button>(R.id.option3)
            val option4 = findViewById<Button>(R.id.option4)
            val questionNo = findViewById<TextView>(R.id.question_no_tv)

            questionNo.text = "${position + 1}."

            if(data != null){
                questionTextView.text = HtmlCompat.fromHtml(data[position].question, HtmlCompat.FROM_HTML_MODE_LEGACY)

                val randVal = Random.nextInt(0, 4)

                if(randVal == 1){
                    cor = 1
                    option1.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else if(randVal == 2){
                    cor = 2
                    option2.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else if(randVal == 3){
                    cor = 3
                    option3.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option4.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }else{
                    cor = 4
                    option4.text = HtmlCompat.fromHtml(data[position].correct_answer, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option2.text = HtmlCompat.fromHtml(data[position].incorrect_answers[0], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option3.text = HtmlCompat.fromHtml(data[position].incorrect_answers[1], HtmlCompat.FROM_HTML_MODE_LEGACY)
                    option1.text = HtmlCompat.fromHtml(data[position].incorrect_answers[2], HtmlCompat.FROM_HTML_MODE_LEGACY)
                }


                var intent = Intent(this, NewQuizPlay::class.java)
                position++
                if(position == totalQ ){
                    intent  = Intent(this, EndActivity::class.java)
                    intent.putExtra("code", 2)
                    intent.putExtra("position", position)
                    intent.putExtra("total_quest", totalQ)
                }else{
                    intent.putExtra("code", 1)
                    intent.putExtra("position", position)
                    intent.putExtra("total_quest", totalQ)
                }






                option1.setOnClickListener {
                    if(cor == 1){
                        points += 1
                        Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }else{
                        Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)

                    }


                }
                option2.setOnClickListener {
                    if(cor == 2){
                        points += 1
                        Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }else{
                        Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }
                }
                option3.setOnClickListener {
                    if(cor == 3){
                        points += 1
                        Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }else{
                        Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }

                }
                option4.setOnClickListener {
                    if(cor == 4){
                        points += 1
                        Toast.makeText(this, "CORRECT ANSWER!!", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }else{
                        Toast.makeText(this, "WRONG ANSWER!! CORRECT ANSWER IS OPTION $cor", Toast.LENGTH_SHORT).show()
                        val handler  = Handler()
                        handler.postDelayed(Runnable { intent.putExtra("current points", points)
                            startActivity(intent) }, 2000)
                    }

                }

            }





        }








        }

    override fun onBackPressed() {
        val dialogbinding = layoutInflater.inflate(R.layout.dialog_box, null)
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogbinding)

        val btnYes = dialogbinding.findViewById<Button>(R.id.Yes_button)
        val btnNo = dialogbinding.findViewById<Button>(R.id.No_button)

        btnYes.setOnClickListener {
            val startIntent = Intent(this, MainActivity::class.java)
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            this.startActivity(startIntent)
        }
        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }












}
