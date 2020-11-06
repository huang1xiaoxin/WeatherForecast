package com.hx.weatherforecast.ViewModel


import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hx.weatherforecast.bean.WeatherBean
import com.hx.weatherforecast.Model.Model
import com.hx.weatherforecast.net.LOCATION_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataViewModel:ViewModel() {
    private var mLiveData: MutableLiveData<List<WeatherBean>> = MutableLiveData()
    var cityData:MutableLiveData<String> =MutableLiveData()
    var model:Model = Model()
    fun getWeatherData(): MutableLiveData<List<WeatherBean>> {
        return mLiveData
    }
    fun getWeatherContent(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val beans: MutableList<WeatherBean> = ArrayList()
            beans.add(model.getWeatherInfo(id))
            withContext(Dispatchers.Main){
                //需要在主线程重赋值
                mLiveData.value=beans
            }

        }
    }
    fun getCityMap(context: Context):MutableMap<String,String>{
        return model.getCityMap(context)
    }
    fun getLocationCityName() {
        viewModelScope.launch(Dispatchers.IO) {
            val temp=model.getLocationCity(LOCATION_KEY)
            val end: Int = temp.city?.indexOf("市")?:-1
            var tempStr = if (end!=-1){
                temp.city?.substring(0, end)?:""
            }else{
                temp.city?:""
            }
            withContext(Dispatchers.Main){
                cityData.value=tempStr
            }
        }
    }



}


