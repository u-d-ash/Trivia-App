package com.example.triviaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.isVisible
import com.example.triviaapp.MainActivity.Companion.quesList
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import retrofit2.HttpException
import java.io.IOException
import kotlin.random.Random


class QuizsetterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.quizsetter)

        val categoryImage = findViewById<ImageView>(R.id.categoryImageView)

        val bundle = intent.extras
        var ActualCategory = ""
        if(bundle != null){
            ActualCategory = bundle.getString("category").toString()
        }
        if(ActualCategory == "Sports"){
            categoryImage.setImageResource(R.drawable.sport_intro)
        }else if(ActualCategory == "General Knowledge"){
            categoryImage.setImageResource(R.drawable.gk_intro)
        }else if(ActualCategory == "Science"){
            categoryImage.setImageResource(R.drawable.science_intro)
        }else{
            categoryImage.setImageResource(R.drawable.entertainment_intro)
        }

        val startButton = findViewById<Button>(R.id.start_button)

        val radioGroup_no_of_questions = findViewById<RadioGroup>(R.id.no_of_questions_radiogroup)
        val radioGroup_difficulty = findViewById<RadioGroup>(R.id.difficulty_radiogroup)

        val loaderBar = findViewById<ProgressBar>(R.id.quizsetterProgressBar)
        loaderBar.isVisible = false


        startButton.setOnClickListener {
            loaderBar.isVisible = true
            val selectedRadioButton_no_of_questions : Int = radioGroup_no_of_questions.checkedRadioButtonId
            val difficulty_selected_button : Int = radioGroup_difficulty.checkedRadioButtonId

            val noOfQuestions_radiobutton_selected = findViewById<RadioButton>(selectedRadioButton_no_of_questions)
            val no_of_q = noOfQuestions_radiobutton_selected.text.toString()
            val diff_radio_selected = findViewById<RadioButton>(difficulty_selected_button)

            val difficulty = diff_radio_selected.text.toString()

            val quesAPI = RetrofitHelper.getInstance().create(QuestionAPI::class.java)

            val intent = Intent(this, NewQuizPlay::class.java)
            intent.putExtra("total_questions", no_of_q.toInt())
            intent.putExtra("code", 0)
            intent.putExtra("current points", 0)

            var cat_string = ""

            if(ActualCategory == "General Knowledge"){
                cat_string = "9"
            }else if(ActualCategory == "Sports"){
                cat_string = "21"
            }else if(ActualCategory == "Entertainment"){
                val rand = Random.nextInt(9, 16)
                cat_string = rand.toString()
            }else{
                val rand = Random.nextInt(16, 19)
                cat_string = rand.toString()
            }

            lifecycleScope.launch {

                val response = try{
                    quesAPI.getQuestions(no_of_q, cat_string, difficulty.lowercase(), "multiple")
                }catch(e: IOException){
                    Log.e("TAG", "IOException")
                    Toast.makeText(this@QuizsetterActivity, "Check your internet connection please", Toast.LENGTH_SHORT).show()
                    loaderBar.isVisible = false
                    return@launch
                }catch (e: HttpException){
                    Log.e("TAG", "HttpException")
                    Toast.makeText(this@QuizsetterActivity, "There's some issue...try again later please", Toast.LENGTH_SHORT).show()
                    loaderBar.isVisible = false
                    return@launch
                }
                if(response.isSuccessful && response.body() != null){
                    val data = (response.body()!!).results
                    val sClass : singletonClass = singletonClass.instance
                    sClass.data = data
                    Log.e("TAG", "Response successful")
                    Log.e("TAG", data.toString())
                    loaderBar.isVisible = false
                    startActivity(intent)
                }else{
                    Log.e("TAG", "Response not successful")
                    loaderBar.isVisible = false
                }

            }










        }
    }
}
