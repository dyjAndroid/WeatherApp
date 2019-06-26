package com.example.weatherapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.domain.commands.RequestForecastCommand
import com.example.weatherapp.extensions.DelegatesExt
import com.example.weatherapp.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {

    private val zipCode: Long by DelegatesExt.preference(
        this,
        SettingsActivity.ZIP_CODE,
        SettingsActivity.DEFAULT_ZIP
    )

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)


    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        Log.d("Sunday", "zipCode:$zipCode")
        val result = RequestForecastCommand(zipCode).execute()
        uiThread {
            forecastList.adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(
                    DetailActivity.ID to it.id,
                    DetailActivity.CITY_NAME to result.city
                )
            }
            toolbarTitle = "${result.city} (${result.country})"
        }
    }
}
