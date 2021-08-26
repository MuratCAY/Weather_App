package com.example.weather_app.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.weather_app.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private val binding: FragmentSplashBinding by lazy { FragmentSplashBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.button.setOnClickListener {
            val action = SplashFragmentDirections.actionSplashFragmentToWeatherPageFragment()
            Navigation.findNavController(it).navigate(action)
        }
        buttonLoginAnim()
        buttonLoginAnim2()
        textTitleAnim()
        textTitleAnim2()

        return binding.root


    }
    fun buttonLoginAnim(){
        val x =  ObjectAnimator.ofFloat(binding.button,"translationY",800.0f,0.0f).apply {
            duration = 2000
        }
        x.start()
    }
    fun buttonLoginAnim2(){
        val x =  ObjectAnimator.ofFloat(binding.button,"rotation",0.0f,720.0f).apply {
            duration = 2000
        }
        x.start()
    }
    fun textTitleAnim(){
        val x =  ObjectAnimator.ofFloat(binding.rainbow,"rotation",0.0f,360.0f).apply {
            duration = 2000
//            interpolator = BounceInterpolator()
        }
        x.start()
    }
    fun textTitleAnim2(){
        val x =  ObjectAnimator.ofFloat(binding.rainbow,"translationY",-800.0f,0.0f).apply {
            duration = 2000
            interpolator = BounceInterpolator()

        }
        x.start()
    }

}