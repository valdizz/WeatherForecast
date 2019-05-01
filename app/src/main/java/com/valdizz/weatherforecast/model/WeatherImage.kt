package com.valdizz.weatherforecast.model

import android.os.Parcelable
import com.valdizz.weatherforecast.R
import kotlinx.android.parcel.Parcelize

/**
 * The types of weather images.
 *
 * @author Vlad Kornev
 */
@Parcelize
enum class WeatherImage(var path: Int) : Parcelable {
    SUN(R.drawable.ic_sun_32dp),
    SNOW(R.drawable.ic_snow_32dp),
    RAIN(R.drawable.ic_rain_32dp),
    CLOUD(R.drawable.ic_cloud_32dp),
    CLOUDY(R.drawable.ic_cloudy_32dp)
}