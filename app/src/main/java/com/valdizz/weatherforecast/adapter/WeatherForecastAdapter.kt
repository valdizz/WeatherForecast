package com.valdizz.weatherforecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.model.Weather
import com.valdizz.weatherforecast.ui.WeatherForecastClickListener
import kotlinx.android.synthetic.main.header_weatherforecast.view.*
import kotlinx.android.synthetic.main.item_weatherforecast.view.*

/**
 * Adapter class for displaying data in [RecyclerView].
 *
 * @author Vlad Kornev
 */
class WeatherForecastAdapter(private val listener: WeatherForecastClickListener?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: MutableList<ListItem> = ArrayList()
    private val drawableCrossFadeFactory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    private class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(data: List<Weather>) {
        this.data = addGroups(data)
        notifyDataSetChanged()
    }

    private fun addGroups(weatherData: List<Weather>): MutableList<ListItem> {
        val dataWithGroups: MutableList<ListItem> = ArrayList()
        val countFavorites = weatherData.filter { it.isFavorite }.count()
        if (countFavorites > 0) {
            dataWithGroups.add(HeaderItem(FAVORITES))
            dataWithGroups.addAll(weatherData.filter { it.isFavorite }.map { WeatherItem(it) })
        }
        dataWithGroups.add(HeaderItem(ALL))
        dataWithGroups.addAll(weatherData.filter { !it.isFavorite }.map { WeatherItem(it) })
        return dataWithGroups
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ListItem.TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.header_weatherforecast,
                    parent,
                    false
                )
            )
            ListItem.TYPE_ITEM -> EventViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_weatherforecast,
                    parent,
                    false
                )
            )
            else -> throw IllegalStateException("Unsupported item type!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ListItem.TYPE_HEADER -> {
                val headerItem = data[position] as HeaderItem
                holder.itemView.tv_group.text = headerItem.name
            }
            ListItem.TYPE_ITEM -> {
                val weatherItem = data[position] as WeatherItem
                val view = holder.itemView
                view.tv_city.text = weatherItem.weather.city.name
                view.tv_info.text = weatherItem.weather.city.info
                view.tv_temperature.text = view.context.getString(R.string.temperature_C, weatherItem.weather.temperature)
                view.iv_weather.setImageDrawable(
                    ContextCompat.getDrawable(view.context, weatherItem.weather.weatherImage.path)
                )
                Glide
                    .with(view.context)
                    .load(weatherItem.weather.city.cityImage)
                    .transition(withCrossFade(drawableCrossFadeFactory))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_city_placeholder)
                    .error(R.drawable.ic_city_error)
                    .fallback(R.drawable.ic_city_fallback)
                    .apply(RequestOptions.circleCropTransform())
                    .into(view.iv_city)

                view.setOnLongClickListener {
                    listener?.onLongClick(weatherItem.weather)
                    true
                }
                view.setOnClickListener {
                    listener?.onClick(weatherItem.weather)
                }
            }
            else -> IllegalStateException("Unsupported item type!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data.get(position).getType()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    companion object {
        private const val ALL = "All"
        private const val FAVORITES = "Favorites"
    }
}