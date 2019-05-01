package com.valdizz.weatherforecast.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.valdizz.weatherforecast.R
import com.valdizz.weatherforecast.model.City
import kotlinx.android.synthetic.main.fragment_city.*
import kotlinx.android.synthetic.main.fragment_city.view.*

/**
 * [CityFragment] contains detail information about the city.
 *
 * @author Vlad Kornev
 */
class CityFragment : Fragment() {

    private val drawableCrossFadeFactory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getParcelable<City>(CITY_ARGS)?.let {
            tv_fr_city.text = it.name
            tv_fr_info.text = it.info
            Glide
                .with(view.context)
                .load(it.cityImage)
                .placeholder(R.drawable.ic_city_placeholder)
                .transition(withCrossFade(drawableCrossFadeFactory))
                .into(view.iv_fr_city)
        }
    }

    companion object {
        private const val CITY_ARGS = "City"

        fun newInstance(city: City) = CityFragment().apply {
            arguments = bundleOf(CITY_ARGS to city)
        }
    }
}