package com.example.weather_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_app.R
import com.example.weather_app.databinding.CardMonthDesignBinding
import com.example.weather_app.model.MonthTemperature

class MonthAdapter(private val context: Context, private val monthList: List<MonthTemperature>) : RecyclerView
.Adapter<MonthAdapter.MonthViewHolder>() {
    inner class MonthViewHolder(val binding: CardMonthDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val binding = CardMonthDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        with(holder) {
            val month = monthList[position]
            binding.dayTextview.text = month.day
            binding.heatRvTextView.text = month.heat
            binding.weatherImageView.setImageResource(
                context.resources.getIdentifier(
                    month.weather_img,
                    context.getString(R.string.drawable), context.packageName
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return monthList.size
    }
}