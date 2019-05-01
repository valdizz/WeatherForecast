package com.valdizz.weatherforecast.adapter

/**
 * Header class.
 *
 * @author Vlad Kornev
 */
class HeaderItem(val name: String) : ListItem() {

    override fun getType(): Int {
        return TYPE_HEADER
    }
}