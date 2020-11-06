package com.hx.weatherforecast.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.hx.weatherforecast.MultiType.ItemData.*
import com.hx.weatherforecast.MultiType.ItemView.*
import com.hx.weatherforecast.R
import com.hx.weatherforecast.ViewModel.DataViewModel
import com.hx.weatherforecast.bean.WeatherBean
import com.hx.weatherforecast.databinding.ActivityMainBinding



class MainActivity:AppCompatActivity(){

    private lateinit var mBind: ActivityMainBinding
    private val mAdapter = MultiTypeAdapter()
    private val mItems = ArrayList<Any>()
    private lateinit var mViewModel: DataViewModel
    private lateinit var mCityMap: MutableMap<String, String>
    private lateinit var mLoadingDialog: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityMainBinding.inflate(layoutInflater)
        val view = mBind.root
        setContentView(view)
        initLoadingDialog()
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        mBind.amRecycleView.layoutManager = linearLayoutManager
        mBind.amRecycleView.adapter = mAdapter
        mAdapter.items = mItems
        registerItems()
        mViewModel=ViewModelProvider(this).get(DataViewModel::class.java)
        mCityMap = mViewModel?.getCityMap(applicationContext)!!
        mViewModel?.getLocationCityName()
        onClick()
        registerLiveDataObserve()
    }

    fun registerLiveDataObserve() {
        mViewModel?.getWeatherData()?.observe(this, Observer<List<WeatherBean>> {
            val weatherBean = it[0]
            mItems.clear()
            mItems.add(TodayWeather(weatherBean))
            mItems.add(FutureWeather(weatherBean))
            mItems.add(WeatherType(weatherBean.data?.forecast))
            mItems.add(HighTemperature(weatherBean.data?.forecast))
            mItems.add(LowTemperature(weatherBean.data?.forecast))
            mItems.add(WinWeather(weatherBean))
            mAdapter.notifyDataSetChanged()
            //加载完数据之后 加载框消失
            hideLoadingDialog()
        })
        mViewModel.cityData.observe(this, {
            loadingWeatherInfo(it)
        })

    }

    fun initViewModel(): DataViewModel {
        return ViewModelProvider(this).get(DataViewModel::class.java)
    }

    private fun onClick() {
        mBind.searchButton.setOnClickListener {
            hideSoftInput()
            val input = mBind.tvSearcherBar.text.toString()
            loadingWeatherInfo(input)
        }
        mBind.loacationButton.setOnClickListener {
            mViewModel?.getLocationCityName()
        }
    }

    private fun loadingWeatherInfo(input: String?) {
        if (input?.length == 0) {
            Toast.makeText(this, "该地址没有相关的天气信息", Toast.LENGTH_SHORT).show()
        } else {
            showLoadingDialog()
            val cityKey = mCityMap[input]
            cityKey?.let { mViewModel?.getWeatherContent(cityKey) }
            hideSoftInput()
        }
    }

    private fun registerItems() {
        mAdapter.register(FutureWeather::class, FutureWeatherItemView())
        mAdapter.register(TodayWeather::class, TodayWeatherItemView())
        mAdapter.register(WinWeather::class, WinWeatherItemView())
        mAdapter.register(LowTemperature::class, LowTemperatureItemView())
        mAdapter.register(HighTemperature::class, HighTemperatureItemView())
        mAdapter.register(WeatherType::class, WeatherTypeItemView())

    }


    //关闭软键盘
    private fun hideSoftInput() {

        val im: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        window.peekDecorView()?.let {
            im.hideSoftInputFromWindow(it.windowToken, 0)
        }

    }

    private fun initLoadingDialog() {
        val layoutParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity = Gravity.CENTER
        mLoadingDialog = LinearLayout(applicationContext)
        mLoadingDialog.orientation = LinearLayout.VERTICAL
        mLoadingDialog.visibility = View.GONE


        val proLayoutParams = FrameLayout.LayoutParams(dip2dp(60), dip2dp(60))
        val progressBar = ProgressBar(applicationContext)
        val drawable = applicationContext.getDrawable(R.drawable.progressbar)
        progressBar.indeterminateDrawable = drawable

        //加载文字的属性
        val textParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        val textView = TextView(applicationContext)
        textView.gravity = Gravity.CENTER
        textView.text = "加载中..."
        textView.layoutParams = textParams
        //添加到View
        this.addContentView(mLoadingDialog, layoutParams)
        mLoadingDialog.addView(progressBar, proLayoutParams)
        mLoadingDialog.addView(textView, textParams)
    }
    private fun dip2dp(dp: Int): Int {
        val scan = baseContext.resources.displayMetrics.density
        return (scan * dp + 0.5f).toInt()
    }
    fun showLoadingDialog() {
        mLoadingDialog.visibility = View.VISIBLE
    }

    fun hideLoadingDialog() {
        mLoadingDialog.visibility = View.GONE
    }

}


