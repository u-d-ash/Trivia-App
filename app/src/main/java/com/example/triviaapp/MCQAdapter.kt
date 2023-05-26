package com.example.triviaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MCQAdapter(val MCQuestions : List<Question>) : RecyclerView.Adapter<MCQAdapter.MCQViewHolder>(){


    inner class MCQViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val questionText: TextView = itemView.findViewById(R.id.question_mc)
        val option1text: TextView = itemView.findViewById(R.id.option_1)
        val option2text: TextView = itemView.findViewById(R.id.option_2)
        val option3text: TextView = itemView.findViewById(R.id.option_3)
        val option4text: TextView = itemView.findViewById(R.id.option_4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MCQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_element_mcq, parent, false)
        return MCQViewHolder(view)
    }
    override fun onBindViewHolder(holder: MCQViewHolder, position: Int) {
        val theQuestion = MCQuestions[position]

        val rand = Random.nextInt(0, 4)

        holder.questionText.text = theQuestion.question

        if(rand == 1){
            holder.option1text.text = theQuestion.correct_answer
            holder.option2text.text = theQuestion.incorrect_answers[0]
            holder.option3text.text = theQuestion.incorrect_answers[1]
            holder.option4text.text = theQuestion.incorrect_answers[2]
        }else if(rand == 2){
            holder.option2text.text = theQuestion.correct_answer
            holder.option1text.text = theQuestion.incorrect_answers[0]
            holder.option3text.text = theQuestion.incorrect_answers[1]
            holder.option4text.text = theQuestion.incorrect_answers[2]
        }else if(rand == 3){
            holder.option3text.text = theQuestion.correct_answer
            holder.option1text.text = theQuestion.incorrect_answers[0]
            holder.option2text.text = theQuestion.incorrect_answers[1]
            holder.option4text.text = theQuestion.incorrect_answers[2]
        }else{
            holder.option4text.text = theQuestion.correct_answer
            holder.option1text.text = theQuestion.incorrect_answers[0]
            holder.option3text.text = theQuestion.incorrect_answers[1]
            holder.option2text.text = theQuestion.incorrect_answers[2]
        }

    }
    override fun getItemCount(): Int {
        return MCQuestions.size
    }






}