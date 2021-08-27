package com.example.weather_app.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weather_app.R
import com.example.weather_app.adapter.TemperatureAdapter
import com.example.weather_app.databinding.FragmentWeatherPageBinding
import com.example.weather_app.model.Temperature

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

        val t1 = Temperature(getString(R.string.hour_6), getString(R.string.ic_rainy_black), getString(R.string.heat_20))
        val t2 = Temperature(getString(R.string.hour_9), getString(R.string.ic_cloudy2), getString(R.string.heat_24))
        val t3 = Temperature(getString(R.string.hour_12), getString(R.string.ic_weather), getString(R.string.heat_28))
        val t4 = Temperature(getString(R.string.hour_15), getString(R.string.ic_weather_sunnly), getString(R.string.heat_30))
        val t5 = Temperature(getString(R.string.hour_18), getString(R.string.ic_sunny), getString(R.string.heat_27))
        val t6 = Temperature(getString(R.string.hour_21), getString(R.string.ic_cloudy2), getString(R.string.heat_26))
        val t7 = Temperature(getString(R.string.hour_24), getString(R.string.ic_rainy_black), getString(R.string.heat_25))

        temperatureArrayList = ArrayList()
        temperatureArrayList.add(t1)
        temperatureArrayList.add(t2)
        temperatureArrayList.add(t3)
        temperatureArrayList.add(t4)
        temperatureArrayList.add(t5)
        temperatureArrayList.add(t6)
        temperatureArrayList.add(t7)

        adapter = TemperatureAdapter(requireContext(), temperatureArrayList)
        binding.rv.adapter = adapter

        val animRv = ObjectAnimator.ofFloat(binding.rv, getString(R.string.translationX), 800.0f, 0.0f).apply {
            duration = 3000
            interpolator = BounceInterpolator()
        }
        animRv.start()

        binding.monthDay.setOnClickListener {
            val action = WeatherPageFragmentDirections.actionWeatherPageFragmentToMonthDayFragment()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

}