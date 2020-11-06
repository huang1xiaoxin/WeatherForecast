package com.hx.weatherforecast.Model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.hx.weatherforecast.bean.CityBean
import com.hx.weatherforecast.bean.LocationBean
import com.hx.weatherforecast.bean.WeatherBean
import com.hx.weatherforecast.net.RetrofitApi
import com.hx.weatherforecast.net.LOCATION_URL
import com.hx.weatherforecast.net.WEATHER_URL

class Model {
    suspend fun getWeatherInfo(id: String): WeatherBean {
        return RetrofitApi.create(WEATHER_URL).getWeatherContent(id)
    }

    suspend fun getLocationCity(id: String):LocationBean{
        return RetrofitApi.create(LOCATION_URL).getLocation(id)
    }

    /**
     * 解析城市的json文件获得
     */
    fun getCityMap(applicationContext: Context): MutableMap<String, String> {
        val inputStream = applicationContext.assets.open("city.json")
        val jsonString = inputStream.reader().readText()
        val jsonParser = JsonParser()
        val jsonElement = jsonParser.parse(jsonString)
        val cityMap: MutableMap<String, String> = mutableMapOf()
        jsonElement.asJsonArray.forEach {
            val cityBean = Gson().fromJson<CityBean>(it, CityBean::class.java)
            var key = cityBean.city_name!!
            var id = cityBean.city_code
            if (id != null) {
                cityMap[key] = id
            }
        }
        return cityMap
    }


}





