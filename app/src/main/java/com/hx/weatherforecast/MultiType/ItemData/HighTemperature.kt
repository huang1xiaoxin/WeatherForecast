package com.hx.weatherforecast.MultiType.ItemData

import com.hx.weatherforecast.bean.WeatherBean

data class HighTemperature constructor(var forecasts: List<WeatherBean.DataBean.ForecastBean>?) {
    var temperatures: MutableList<Int> = ArrayList()
    init {
        val sequence = forecasts?.asSequence()
        sequence?.map {
            //提取出“高温 19℃”的数字
            val start = it.high?.indexOf(" ")?:-1
            var end = it.high?.indexOf(".")?:-1
            if (end==-1){
                end= it.high?.indexOf("℃")?:-1
            }
            val value=it.high?.substring(start+1,end)
            temperatures.add(value?.toInt()?:0)
        }?.take(7)?.toList()
    }

}