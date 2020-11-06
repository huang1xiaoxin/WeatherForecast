package com.hx.weatherforecast.MultiType.ItemData

import com.hx.weatherforecast.R
import com.hx.weatherforecast.bean.WeatherBean


data class TodayWeather constructor(val weatherBean: WeatherBean) {
    var pm :String =weatherBean.data?.pm25.toString()
    var shidu =weatherBean.data?.shidu?:"30%"
    var wendu:String =(weatherBean.data?.wendu?:"25")+"℃"
    var quality=weatherBean.data?.quality?:"轻度"
    var typeId: Int = weatherBean.data?.forecast?.get(0)?.type?.let { WeatherType.typeMap[it]}?: R.drawable.duoyun
    var city:String=weatherBean.cityInfo?.city?:""
}