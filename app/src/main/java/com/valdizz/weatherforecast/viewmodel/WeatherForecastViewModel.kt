package com.valdizz.weatherforecast.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.valdizz.weatherforecast.model.MockData
import com.valdizz.weatherforecast.model.Weather
import com.valdizz.weatherforecast.ui.SortType

/**
 * ViewModel class implements the logic of managing weather data.
 *
 * @author Vlad Kornev
 */
class WeatherForecastViewModel(application: Application) : AndroidViewModel(application) {

    private val model = MockData()
    private val data: MutableLiveData<List<Weather>> = MutableLiveData()
    private var sortType: SortType? = null

    init {
        loadData()
    }

    fun getData(): LiveData<List<Weather>> {
        return data
    }

    private fun loadData() {
        data.value = model.getData()
    }

    fun sortData(type: SortType?) {
        when (type) {
            SortType.NAME -> data.value = data.value?.sortedBy { it.city.name }
            SortType.NAME_DESC -> data.value = data.value?.sortedByDescending { it.city.name }
            SortType.TEMP -> data.value = data.value?.sortedBy { it.temperature }
            SortType.TEMP_DESC -> data.value = data.value?.sortedByDescending { it.temperature }
        }
        sortType = type
    }

    fun addOrRemoveFavorite(weather: Weather) {
        val list: MutableList<Weather>? = data.value?.toMutableList()
        if (weather.isFavorite) {
            list?.remove(weather)
        } else {
            val newItem = Weather(weather.city, weather.temperature, weather.weatherImage, true)
            if (list?.contains(newItem) == false) {
                list.add(newItem)
            }
        }
        data.value = list
        sortData(sortType)
    }
}