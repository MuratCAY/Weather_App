package com.example.weather_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.weather_app.R
import com.example.weather_app.adapter.MonthAdapter
import com.example.weather_app.databinding.FragmentMonthDayBinding
import com.example.weather_app.model.MonthTemperature

class MonthDayFragment : Fragment() {
    private val binding: FragmentMonthDayBinding by lazy { FragmentMonthDayBinding.inflate(layoutInflater) }
    private lateinit var monthArrayList: ArrayList<MonthTemperature>
    private lateinit var adapter: MonthAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.rvMonth.setHasFixedSize(true)
        binding.rvMonth.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val m1 = MonthTemperature(getString(R.string.pazartesi), getString(R.string.ic_cloudy2), getString(R.string.heat_30))
        val m2 = MonthTemperature(getString(R.string.sali), getString(R.string.ic_rainy_black), getString(R.string.heat_28))
        val m3 = MonthTemperature(getString(R.string.carsamba), getString(R.string.ic_weather), getString(R.string.heat_27))
        val m4 = MonthTemperature(getString(R.string.persembe), getString(R.string.ic_sunny), getString(R.string.hate_32))
        val m5 =
            MonthTemperature(getString(R.string.cuma), getString(R.string.ic_weather_sunnly), getString(R.string.hate_31))
        val m6 = MonthTemperature(getString(R.string.cumartesi), getString(R.string.ic_sunny), getString(R.string.heat_30))
        val m7 = MonthTemperature(getString(R.string.pazar), getString(R.string.ic_sunny), getString(R.string.hate_29))

        monthArrayList = ArrayList()
        monthArrayList.add(m1)
        monthArrayList.add(m2)
        monthArrayList.add(m3)
        monthArrayList.add(m4)
        monthArrayList.add(m5)
        monthArrayList.add(m6)
        monthArrayList.add(m7)

        adapter = MonthAdapter(requireContext(), monthArrayList)
        binding.rvMonth.adapter = adapter

        return binding.root
    }

}