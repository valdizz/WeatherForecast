package com.valdizz.weatherforecast.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.adapter.WeatherForecastAdapter
import com.valdizz.weatherforecast.model.Weather
import com.valdizz.weatherforecast.viewmodel.WeatherForecastViewModel
import kotlinx.android.synthetic.main.fragment_weatherforecast.*

/**
 * [WeatherForecastFragment] displays a list with the weather forecast for the cities.
 * The data can be sorted by city name and temperature.
 *
 * @author Vlad Kornev
 */
class WeatherForecastFragment : Fragment() {

    private lateinit var viewModel: WeatherForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(WeatherForecastViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weatherforecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = WeatherForecastAdapter(listener)
        rv_weather_forecast.layoutManager = LinearLayoutManager(activity)
        rv_weather_forecast.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_weather_forecast.adapter = adapter

        viewModel.getData().observe(this, Observer { data -> adapter.setData(data) })
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_weatherforecast, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_sort_by_name -> {
                viewModel.sortData(SortType.NAME)
                return true
            }
            R.id.action_sort_by_name_desc -> {
                viewModel.sortData(SortType.NAME_DESC)
                return true
            }
            R.id.action_sort_by_temp -> {
                viewModel.sortData(SortType.TEMP)
                return true
            }
            R.id.action_sort_by_temp_desc -> {
                viewModel.sortData(SortType.TEMP_DESC)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private val listener: WeatherForecastClickListener = object: WeatherForecastClickListener {
        override fun onClick(weather: Weather) {
            activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.fragment_container, CityWeatherFragment.newInstance(weather))?.
                addToBackStack(null)?.commit()
        }

        override fun onLongClick(weather: Weather) {
            val dialog = AlertDialog.Builder(activity as Context)
                .setMessage(if (weather.isFavorite) R.string.alert_remove_favorites else R.string.alert_add_favorites)
                .setPositiveButton(android.R.string.ok) { _, _ ->  run {
                    viewModel.addOrRemoveFavorite(weather)
                }}
                .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.cancel() }
                .create()
            dialog.show()
        }
    }

    companion object {
        fun newInstance() = WeatherForecastFragment()
    }
}