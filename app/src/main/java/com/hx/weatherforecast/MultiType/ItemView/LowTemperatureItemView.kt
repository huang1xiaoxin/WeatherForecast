package com.hx.weatherforecast.MultiType.ItemView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.hx.weatherforecast.MultiType.ItemData.HighTemperature
import com.hx.weatherforecast.MultiType.ItemData.LowTemperature
import com.hx.weatherforecast.R
import com.hx.weatherforecast.ui.MyLineChart
import kotlinx.android.synthetic.main.high_item_view.view.*

class LowTemperatureItemView :ItemViewBinder<LowTemperature,LowTemperatureItemView.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view =inflater.inflate(R.layout.low_item_view,parent,false)
        return ViewHolder(view)
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val  chartLine:MyLineChart=itemView.findViewById(R.id.line_chart)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: LowTemperature) {
        holder.chartLine.pointData=item.temperatures
    }
}