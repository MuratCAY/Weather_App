package com.example.weather_app.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weather_app.Temperature
import com.example.weather_app.adapter.TemperatureAdapter
import com.example.weather_app.databinding.FragmentWeatherPageBinding

class WeatherPageFragment : Fragment() {
    private val binding: FragmentWeatherPageBinding by lazy { FragmentWeatherPageBinding.inflate(layoutInflater) }
    private lateinit var temperatureArrayList: ArrayList<Temperature>
    private lateinit var adapter: TemperatureAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
//        val currentDateAndTime: String = simpleDateFormat.format(Date())
//        binding.date.text = currentDateAndTime

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val t1 = Temperature("6 AM", "ic_rainy_black", "20°C")
        val t2 = Temperature("9 AM", "ic_cloudy2", "24°C")
        val t3 = Temperature("12 PM", "ic_weather", "28°C")
        val t4 = Temperature("15 PM", "ic_weather_sunnly", "30°C")
        val t5 = Temperature("18 PM", "ic_sunny", "27°C")
        val t6 = Temperature("21 PM", "ic_cloudy2", "26°C")
        val t7 = Temperature("24 PM", "ic_rainy_black", "25°C")

        temperatureArrayList = ArrayList<Temperature>()
        temperatureArrayList.add(t1)
        temperatureArrayList.add(t2)
        temperatureArrayList.add(t3)
        temperatureArrayList.add(t4)
        temperatureArrayList.add(t5)
        temperatureArrayList.add(t6)
        temperatureArrayList.add(t7)

        adapter = TemperatureAdapter(requireContext(), temperatureArrayList)
        binding.rv.adapter = adapter

        val animRv = ObjectAnimator.ofFloat(binding.rv,"translationX",800.0f,0.0f).apply {
            duration = 2000
        }
        animRv.start()

        return binding.root
    }

}