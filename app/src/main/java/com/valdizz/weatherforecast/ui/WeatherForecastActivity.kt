package com.valdizz.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.viewmodel.WeatherForecastViewModel
import kotlinx.android.synthetic.main.activity_weatherforecast.*

/**
 * [WeatherForecastActivity] has a fragment that contains the weather forecast.
 *
 * @author Vlad Kornev
 */
class WeatherForecastActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weatherforecast)
        viewModel = ViewModelProviders.of(this).get(WeatherForecastViewModel::class.java)
        setSupportActionBar(toolbar)
        createWeatherForecastFragment()
    }

    private fun createWeatherForecastFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, WeatherForecastFragment.newInstance())
            .commit()
    }
}
