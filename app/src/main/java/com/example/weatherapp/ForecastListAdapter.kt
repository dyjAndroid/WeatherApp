package com.example.weatherapp

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.domain.model.ForecastList

/**
 * created by Sunday
 * on 2019-06-24 14:33
 */
class ForecastListAdapter(private val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}