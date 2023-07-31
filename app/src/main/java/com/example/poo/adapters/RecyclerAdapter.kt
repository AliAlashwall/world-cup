package com.example.poo.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poo.interact
import com.example.poo.R
import com.example.poo.databinding.RecyclerItemBinding
import com.example.poo.parsing.Match

lateinit var name :String
class Adapter(val list: List<Match>, val listener : interact):RecyclerView.Adapter<Adapter.ViewHolder>() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {          //عمليه التحويل بتتم هنا
        val currentMatch = list[position]
        holder.binding.apply {
        homeTeam.text = currentMatch.homeTeam
        homeTeamGoal.text = currentMatch.homeTeamGoal
        awayTeam.text = currentMatch.awayTeam
        awayTeamGoal.text = currentMatch.awayTeamGoal

            root.setOnClickListener {
                name = if (currentMatch.homeTeamGoal > currentMatch.awayTeamGoal){
                    currentMatch.homeTeam
                } else if (currentMatch.homeTeamGoal < currentMatch.awayTeamGoal){
                    currentMatch.awayTeam
                }
                else{"Equal"}
                listener.onClickName(name)
            }

        }

    }

     class ViewHolder(viewItem : View): RecyclerView.ViewHolder(viewItem) {
        val binding = RecyclerItemBinding.bind(viewItem)
    }
}