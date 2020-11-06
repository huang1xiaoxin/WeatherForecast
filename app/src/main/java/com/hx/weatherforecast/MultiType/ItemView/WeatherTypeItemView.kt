package com.hx.weatherforecast.MultiType.ItemView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.hx.weatherforecast.MultiType.ItemData.WeatherType
import com.hx.weatherforecast.R

class WeatherTypeItemView:ItemViewBinder<WeatherType,WeatherTypeItemView.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val todayIV: ImageView =itemView.findViewById(R.id.today_image_view)
        val tomorrowIV: ImageView =itemView.findViewById(R.id.tomorrow_image_view)
        val oneIV: ImageView =itemView.findViewById(R.id.one_image_view)
        val twoIV: ImageView =itemView.findViewById(R.id.two_image_view)
        val threeIV: ImageView =itemView.findViewById(R.id.three_image_view)
        val fourIV: ImageView =itemView.findViewById(R.id.four_image_view)
        val fiveIV: ImageView =itemView.findViewById(R.id.five_image_view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: WeatherType) {
        holder.todayIV.setImageResource(item.typeIds[0])
        holder.tomorrowIV.setImageResource(item.typeIds[1])
        holder.oneIV.setImageResource(item.typeIds[2])
        holder.twoIV.setImageResource(item.typeIds[3])
        holder.threeIV.setImageResource(item.typeIds[4])
        holder.fourIV.setImageResource(item.typeIds[5])
        holder.fiveIV.setImageResource(item.typeIds[6])
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.weaher_type_item_view,parent,false))
    }
}