package com.hx.weatherforecast.MultiType.ItemView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.hx.weatherforecast.MultiType.ItemData.FutureWeather
import com.hx.weatherforecast.MultiType.ItemData.TodayWeather
import com.hx.weatherforecast.MultiType.ItemData.WinWeather
import com.hx.weatherforecast.MultiType.ItemData.dataFormat
import com.hx.weatherforecast.R

class WinWeatherItemView : ItemViewBinder<WinWeather, WinWeatherItemView.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, item: WinWeather) {
        var wins=item.dataBean?.forecast
        holder.tomorrowTV.text= winValueFormat(wins?.get(0)?.fx.toString(),wins?.get(0)?.fl.toString())
        holder.todayTV.text= winValueFormat(wins?.get(1)?.fx.toString(),wins?.get(1)?.fl.toString())
        holder.oneTV.text= winValueFormat(wins?.get(2)?.fx.toString(),wins?.get(2)?.fl.toString())
        holder.twoTV.text= winValueFormat(wins?.get(3)?.fx.toString(),wins?.get(3)?.fl.toString())
        holder.threeTV.text= winValueFormat(wins?.get(4)?.fx.toString(),wins?.get(4)?.fl.toString())
        holder.fourTV.text= winValueFormat(wins?.get(5)?.fx.toString(),wins?.get(6)?.fl.toString())
        holder.fiveTV.text= winValueFormat(wins?.get(7)?.fx.toString(),wins?.get(7)?.fl.toString())
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.date_itemview,parent,false))
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tomorrowTV: TextView =itemView.findViewById(R.id.tomorrow_text_view)
        val todayTV: TextView =itemView.findViewById(R.id.today_text_view)
        val oneTV: TextView =itemView.findViewById(R.id.one_text_view)
        val twoTV: TextView =itemView.findViewById(R.id.two_text_view)
        val threeTV: TextView =itemView.findViewById(R.id.three_text_view)
        val fourTV: TextView =itemView.findViewById(R.id.four_text_view)
        val fiveTV: TextView =itemView.findViewById(R.id.five_text_view)
    }
    private fun winValueFormat(win:String,value:String):String {
        return win+"\n\n"+value
    }
}