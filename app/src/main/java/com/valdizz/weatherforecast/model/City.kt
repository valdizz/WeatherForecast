package com.valdizz.weatherforecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * City description data class.
 *
 * @author Vlad Kornev
 */
@Parcelize
data class City(val name: String, val info: String, val cityImage: String) : Parcelable