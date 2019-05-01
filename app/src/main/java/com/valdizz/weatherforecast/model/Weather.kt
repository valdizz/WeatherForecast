package com.valdizz.weatherforecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Weather forecast data class.
 *
 * @author Vlad Kornev
 */
@Parcelize
data class Weather(val city: City, val temperature: Int, val weatherImage: WeatherImage, val isFavorite: Boolean) : Parcelable