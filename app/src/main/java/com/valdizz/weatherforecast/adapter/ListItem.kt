package com.valdizz.weatherforecast.adapter

/**
 * Abstract class defines the type of record.
 *
 * @author Vlad Kornev
 */
abstract class ListItem {

    abstract fun getType(): Int

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }
}