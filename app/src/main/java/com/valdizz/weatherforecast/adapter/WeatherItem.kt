package com.valdizz.weatherforecast.adapter

import com.valdizz.weatherforecast.model.Weather

/**
 * Class with weather forecast.
 *
 * @author Vlad Kornev
 */
class WeatherItem(val weather: Weather) : ListItem() {

    override fun getType(): Int {
        return TYPE_ITEM
    }
}