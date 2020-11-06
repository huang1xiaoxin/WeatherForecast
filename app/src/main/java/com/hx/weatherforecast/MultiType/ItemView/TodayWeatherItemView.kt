package com.hx.weatherforecast.MultiType.ItemView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.hx.weatherforecast.MultiType.ItemData.TodayWeather
import com.hx.weatherforecast.R


class TodayWeatherItemView : ItemViewBinder<TodayWeather, TodayWeatherItemView.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: TodayWeather) {
        holder.shiduTV.text = item.shidu
        holder.pmTV.text = item.pm
        holder.qualityTV.text = item.quality
        holder.wenduTV.text = item.wendu
        holder.image.setImageResource(item.typeId)
        holder.cityTextView.text=item.city
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view = inflater.inflate(R.layout.today_weather_itemview, parent, false)
        return ViewHolder(view)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //这里如果不加上类型的，就需要在findViewById<>的泛型中指明类型
        val wenduTV: TextView = itemView.findViewById(R.id.wendu_textview)
        val shiduTV: TextView = itemView.findViewById(R.id.shidu_value)
        val qualityTV: TextView = itemView.findViewById(R.id.quality_value)
        val pmTV: TextView = itemView.findViewById(R.id.pm_value)
        val image:ImageView=itemView.findViewById(R.id.image)
        val cityTextView:TextView=itemView.findViewById(R.id.city)
    }

}