package com.example.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ViewBinding
import java.util.Locale

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {

    class viewHolder(private val binding: ViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cardInfo: CardInfo){
            when(cardInfo.priority.lowercase()){
                "high" -> binding.layout.setBackgroundColor(Color.parseColor("#FF0000"))
                "medium" -> binding.layout.setBackgroundColor(Color.parseColor("#FFFF00"))
                else -> binding.layout.setBackgroundColor(Color.parseColor("#008000"))
            }
            binding.title.text = cardInfo.title
            binding.priority.text = cardInfo.title

            binding.layout.setOnClickListener {
                val intent = Intent(binding.layout.context,EnterDetails::class.java)
                binding.layout.context.startActivity(intent)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val item = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(data[position])
    }
}