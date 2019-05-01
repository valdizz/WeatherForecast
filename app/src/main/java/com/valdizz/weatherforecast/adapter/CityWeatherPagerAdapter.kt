package com.valdizz.weatherforecast.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.valdizz.weatherforecast.model.Weather
import com.valdizz.weatherforecast.ui.CityFragment
import com.valdizz.weatherforecast.ui.WeatherFragment

/**
 * Adapter class for managing pages in [ViewPager].
 *
 * @author Vlad Kornev
 */
class CityWeatherPagerAdapter(fragmentManager: FragmentManager?, val weather: Weather) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CityFragment.newInstance(weather.city)
            1 -> WeatherFragment.newInstance(weather.temperature, weather.weatherImage)
            else -> CityFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> CITY
            1 -> WEATHER
            else -> CITY
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    companion object {
        private const val COUNT = 2
        private const val CITY = "City"
        private const val WEATHER = "Weather"
    }
}