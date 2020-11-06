package com.hx.weatherforecast.MultiType.ItemData

import android.util.Log
import com.hx.weatherforecast.R
import com.hx.weatherforecast.bean.WeatherBean

data class WeatherType constructor(var forcasts: List<WeatherBean.DataBean.ForecastBean>?) {

    var typeIds: MutableList<Int> = ArrayList()

    //最后一定要加上toList,否则typeIds添加不成功
    init {
        forcasts?.asSequence()?.map {
            typeIds.add(typeMap[it.type] ?: R.drawable.duoyun)
            Log.e("@@@", "${typeIds.size}")
        }?.take(7)?.toList()
    }

    companion object {
        var typeMap: MutableMap<String, Int> = initMap()
        private fun initMap(): MutableMap<String, Int> {
            var map: MutableMap<String, Int> = mutableMapOf()
            map["晴"] = R.drawable.qing
            map["暴雪"] = R.drawable.baoxue
            map["暴雨"] = R.drawable.baoyu
            map["大暴雨"] = R.drawable.dabaoyu
            map["大雪"] = R.drawable.daxue
            map["大雨"] = R.drawable.dayu
            map["多云"] = R.drawable.duoyun
            map["浮尘"] = R.drawable.fuchen
            map["雷阵雨"] = R.drawable.leizhenyu
            map["雷阵雨并有冰雹"] = R.drawable.leizhenyubingyoubingbao
            map["沙尘暴"] = R.drawable.shachenbao
            map["特大暴雨"] = R.drawable.tedabaoyu
            map["雾"] = R.drawable.wu
            map["小雪"] = R.drawable.xiaoxue
            map["小雨"] = R.drawable.xioayu
            map["扬沙"] = R.drawable.yangsha
            map["阴"] = R.drawable.yin
            map["雨夹雪"] = R.drawable.yujiaxue
            map["阵雨"] = R.drawable.zhenyu
            map["中雨"] = R.drawable.zhongyu
            map["小到中雨"] = R.drawable.xiaodaozhongyu
            map["霾"] = R.drawable.wumai
            return map
        }
    }
}