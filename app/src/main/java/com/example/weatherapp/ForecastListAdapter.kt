package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.ForecastList
import com.example.weatherapp.extensions.ctx

/**
 * created by Sunday
 * on 2019-06-24 14:33
 */
class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: OnItemClickListener) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    class ViewHolder(private val view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        private val iconView: ImageView = view.findViewById(R.id.icon)
        private val dateView: TextView = view.findViewById(R.id.dateText)
        private val descriptionView: TextView = view.findViewById(R.id.descriptionText)
        private val maxTemperatureView: TextView = view.findViewById(R.id.maxTemperature)
        private val minTemperatureView: TextView = view.findViewById(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Glide.with(view.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                view.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}