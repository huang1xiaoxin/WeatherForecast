package com.hx.weatherforecast.MultiType.ItemView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.hx.weatherforecast.MultiType.ItemData.FutureWeather
import com.hx.weatherforecast.MultiType.ItemData.dataFormat
import com.hx.weatherforecast.R

class FutureWeatherItemView : ItemViewBinder<FutureWeather, FutureWeatherItemView.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, item: FutureWeather) {
        var forecasts=item.dataBean?.forecast?:return
        holder.tomorrowTV.text= dataFormat(forecasts[1].ymd,forecasts[1].week?.replace("星期","周"))
        holder.todayTV.text= dataFormat(forecasts[0].ymd,"今天")
        holder.oneTV.text= dataFormat(forecasts[2].ymd,forecasts[2].week?.replace("星期","周"))
        holder.twoTV.text= dataFormat(forecasts[3].ymd,forecasts[3].week?.replace("星期","周"))
        holder.threeTV.text= dataFormat(forecasts[4].ymd,forecasts[4].week?.replace("星期","周"))
        holder.fourTV.text= dataFormat(forecasts[5].ymd,forecasts[5].week?.replace("星期","周"))
        holder.fiveTV.text= dataFormat(forecasts[6].ymd,forecasts[6].week?.replace("星期","周"))


    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view=inflater.inflate(R.layout.date_itemview,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val todayTV:TextView=itemView.findViewById(R.id.today_text_view)
        val tomorrowTV:TextView=itemView.findViewById(R.id.tomorrow_text_view)
        val oneTV:TextView=itemView.findViewById(R.id.one_text_view)
        val twoTV:TextView=itemView.findViewById(R.id.two_text_view)
        val threeTV:TextView=itemView.findViewById(R.id.three_text_view)
        val fourTV:TextView=itemView.findViewById(R.id.four_text_view)
        val fiveTV:TextView=itemView.findViewById(R.id.five_text_view)


    }
}