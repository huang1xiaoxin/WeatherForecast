package com.hx.weatherforecast.net

import android.location.Location
import com.hx.weatherforecast.bean.LocationBean
import com.hx.weatherforecast.bean.WeatherBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val WEATHER_URL="http://t.weather.itboy.net/api/weather/"
const val LOCATION_URL="https://restapi.amap.com/v3/"
const val LOCATION_KEY="0113a13c88697dcea6a445584d535837"
interface RetrofitApi {
    @GET("city/{id}")
    suspend  fun  getWeatherContent(@Path("id" )id:String):WeatherBean

    @GET("ip")
    suspend fun getLocation(@Query("key") id: String): LocationBean

    companion object{



        fun create(baseUrl:String):RetrofitApi{
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitApi::class.java)
        }
    }

}