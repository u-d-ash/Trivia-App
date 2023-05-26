package com.example.triviaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class TFAdapter(var TFQuestions : List<Question>):RecyclerView.Adapter<TFAdapter.TFQViewHolder>(){

    inner class TFQViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val questionText: TextView = itemView.findViewById(R.id.question_mc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TFQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_element_tf, parent, false)
       return TFQViewHolder(view)
    }

    override fun onBindViewHolder(holder: TFQViewHolder, position: Int) {
        holder.questionText.text = TFQuestions[position].question
    }

    override fun getItemCount(): Int {
        return TFQuestions.size
    }

}