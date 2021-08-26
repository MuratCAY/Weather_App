package com.example.weather_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_app.Temperature
import com.example.weather_app.databinding.CardDaysDesignBinding

class TemperatureAdapter(private val context: Context, private val temperatureList: List<Temperature>) : RecyclerView
.Adapter<TemperatureAdapter.TemperatureViewHolder>() {
    inner class TemperatureViewHolder(val binding: CardDaysDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureViewHolder {
        val binding = CardDaysDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TemperatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TemperatureViewHolder, position: Int) {
        with(holder) {
            val temperature = temperatureList[position]
            binding.hourText.text = temperature.hour
            binding.weatherImg.setImageResource(
                context.resources.getIdentifier(
                    temperature.weather_img, "drawable", context
                        .packageName
                )
            )
            binding.heatRvText.text = temperature.heat
        }

    }

    override fun getItemCount(): Int {
        return temperatureList.size
    }
}