package com.valdizz.weatherforecast.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.adapter.CityWeatherPagerAdapter
import com.valdizz.weatherforecast.adapter.ZoomOutPageTransformer
import com.valdizz.weatherforecast.model.Weather
import kotlinx.android.synthetic.main.fragment_cityweather.*

/**
 * [CityWeatherFragment] contains [ViewPager] with detail information about the city and the weather.
 *
 * @author Vlad Kornev
 */
class CityWeatherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cityweather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getParcelable<Weather>(WEATHER_ARGS)?.let {
            val pagerAdapter = CityWeatherPagerAdapter(fragmentManager, it)
            vp_cityweather.setPageTransformer(true, ZoomOutPageTransformer())
            vp_cityweather.adapter = pagerAdapter
        }
    }

    companion object {
        private const val WEATHER_ARGS = "Weather"

        fun newInstance(weather: Weather) = CityWeatherFragment().apply {
            arguments = bundleOf(WEATHER_ARGS to weather)
        }
    }
}