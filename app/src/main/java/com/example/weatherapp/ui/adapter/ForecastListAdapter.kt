package com.example.weatherapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.ForecastList
import com.example.weatherapp.extensions.ctx
import com.example.weatherapp.extensions.toDateString
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.DateFormat

/**
 * created by Sunday
 * on 2019-06-24 14:33
 */
class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(private val view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Glide.with(view.ctx).load(iconUrl).into(view.icon)
                view.dateText.text = date.toDateString(DateFormat.FULL)
                view.descriptionText.text = description
                view.maxTemperature.text = "$high"
                view.minTemperature.text = "$low"
                view.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}