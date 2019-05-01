package com.valdizz.weatherforecast.ui

import com.valdizz.weatherforecast.model.Weather

/**
 * Interface for listening to click and long click events on RecyclerView.
 *
 * @author Vlad Kornev
 */
interface WeatherForecastClickListener {

    fun onClick(weather: Weather)
    fun onLongClick(weather: Weather)
}