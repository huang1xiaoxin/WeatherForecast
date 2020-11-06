package com.hx.weatherforecast.MultiType.ItemData

import com.hx.weatherforecast.bean.WeatherBean

data class WinWeather(var bean: WeatherBean)  {
    var dataBean=bean.data
}