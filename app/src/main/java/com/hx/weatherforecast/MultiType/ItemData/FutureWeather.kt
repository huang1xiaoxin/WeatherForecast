package com.hx.weatherforecast.MultiType.ItemData

import com.hx.weatherforecast.bean.WeatherBean

//处理日期
fun dataFormat(ymd:String?,week:String?) : String{
    val index=ymd?.indexOf("-")
    if (index != null) {
        return week+"\n\n"+ymd?.substring(index+1,ymd.length)
    }
    return "未知"
}
data class FutureWeather(val weatherBean: WeatherBean)  {
    var dataBean=weatherBean.data
}

