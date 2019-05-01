package com.valdizz.weatherforecast.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.model.WeatherImage
import kotlinx.android.synthetic.main.fragment_weather.*

/**
 * [WeatherFragment] contains detail information about the weather.
 *
 * @author Vlad Kornev
 */
class WeatherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getInt(WEATHER_TEMP_ARGS)?.let {
            tv_fr_temperature.text = getString(R.string.temperature_C, it)
        }
        arguments?.getParcelable<WeatherImage>(WEATHER_IMAGE_ARGS)?.let {
            iv_fr_weather.setImageDrawable(ContextCompat.getDrawable(view.context, it.path))
        }
    }

    companion object {
        private const val WEATHER_TEMP_ARGS = "Temp"
        private const val WEATHER_IMAGE_ARGS = "Image"

        fun newInstance(temperature: Int, weatherImage: WeatherImage) = WeatherFragment().apply {
            arguments = bundleOf(
                WEATHER_TEMP_ARGS to temperature,
                WEATHER_IMAGE_ARGS to weatherImage
            )
        }
    }
}