package com.hx.weatherforecast.bean

class WeatherBean {
    /**
     * message : success感谢又拍云(upyun.com)提供CDN赞助
     * status : 200
     * date : 20201030
     * time : 2020-10-30 14:48:27
     * cityInfo : {"city":"天津市","citykey":"101030100","parent":"天津","updateTime":"11:46"}
     * data : {"shidu":"35%","pm25":77,"pm10":111,"quality":"轻度","wendu":"16","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼","forecast":[{"date":"30","high":"高温 20℃","low":"低温 11℃","ymd":"2020-10-30","week":"星期五","sunrise":"06:37","sunset":"17:13","aqi":95,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31","high":"高温 19℃","low":"低温 7℃","ymd":"2020-10-31","week":"星期六","sunrise":"06:38","sunset":"17:12","aqi":91,"fx":"西风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"01","high":"高温 17℃","low":"低温 6℃","ymd":"2020-11-01","week":"星期日","sunrise":"06:39","sunset":"17:11","aqi":52,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"02","high":"高温 15℃","low":"低温 5℃","ymd":"2020-11-02","week":"星期一","sunrise":"06:40","sunset":"17:09","aqi":38,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"03","high":"高温 15℃","low":"低温 6℃","ymd":"2020-11-03","week":"星期二","sunrise":"06:41","sunset":"17:08","aqi":30,"fx":"北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"04","high":"高温 17℃","low":"低温 8℃","ymd":"2020-11-04","week":"星期三","sunrise":"06:42","sunset":"17:07","aqi":65,"fx":"西南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"05","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-05","week":"星期四","sunrise":"06:43","sunset":"17:06","aqi":89,"fx":"西南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-06","week":"星期五","sunrise":"06:44","sunset":"17:05","aqi":65,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07","high":"高温 19℃","low":"低温 10℃","ymd":"2020-11-07","week":"星期六","sunrise":"06:46","sunset":"17:04","aqi":59,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08","high":"高温 19℃","low":"低温 11℃","ymd":"2020-11-08","week":"星期日","sunrise":"06:47","sunset":"17:03","aqi":81,"fx":"西南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","high":"高温 20℃","low":"低温 11℃","ymd":"2020-11-09","week":"星期一","sunrise":"06:48","sunset":"17:02","aqi":81,"fx":"西风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"10","high":"高温 21℃","low":"低温 12℃","ymd":"2020-11-10","week":"星期二","sunrise":"06:49","sunset":"17:01","aqi":69,"fx":"西风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"11","high":"高温 22℃","low":"低温 12℃","ymd":"2020-11-11","week":"星期三","sunrise":"06:50","sunset":"17:00","aqi":76,"fx":"东北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-12","week":"星期四","sunrise":"06:51","sunset":"17:00","aqi":57,"fx":"东风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","high":"高温 21℃","low":"低温 10℃","ymd":"2020-11-13","week":"星期五","sunrise":"06:52","sunset":"16:59","aqi":67,"fx":"东南风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}],"yesterday":{"date":"29","high":"高温 19℃","low":"低温 8℃","ymd":"2020-10-29","week":"星期四","sunrise":"06:36","sunset":"17:14","aqi":88,"fx":"西南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"}}
     */
    var message: String? = null
    var status = 0
    var date: String? = null
    var time: String? = null
    var cityInfo: CityInfoBean? = null
    var data: DataBean? = null



    class CityInfoBean {
        /**
         * city : 天津市
         * citykey : 101030100
         * parent : 天津
         * updateTime : 11:46
         */
        var city: String? = null
        var citykey: String? = null
        var parent: String? = null
        var updateTime: String? = null
    }

    class DataBean {
        /**
         * shidu : 35%
         * pm25 : 77.0
         * pm10 : 111.0
         * quality : 轻度
         * wendu : 16
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
         * forecast : [{"date":"30","high":"高温 20℃","low":"低温 11℃","ymd":"2020-10-30","week":"星期五","sunrise":"06:37","sunset":"17:13","aqi":95,"fx":"南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"31","high":"高温 19℃","low":"低温 7℃","ymd":"2020-10-31","week":"星期六","sunrise":"06:38","sunset":"17:12","aqi":91,"fx":"西风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"01","high":"高温 17℃","low":"低温 6℃","ymd":"2020-11-01","week":"星期日","sunrise":"06:39","sunset":"17:11","aqi":52,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"02","high":"高温 15℃","low":"低温 5℃","ymd":"2020-11-02","week":"星期一","sunrise":"06:40","sunset":"17:09","aqi":38,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"03","high":"高温 15℃","low":"低温 6℃","ymd":"2020-11-03","week":"星期二","sunrise":"06:41","sunset":"17:08","aqi":30,"fx":"北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"04","high":"高温 17℃","low":"低温 8℃","ymd":"2020-11-04","week":"星期三","sunrise":"06:42","sunset":"17:07","aqi":65,"fx":"西南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"05","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-05","week":"星期四","sunrise":"06:43","sunset":"17:06","aqi":89,"fx":"西南风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-06","week":"星期五","sunrise":"06:44","sunset":"17:05","aqi":65,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07","high":"高温 19℃","low":"低温 10℃","ymd":"2020-11-07","week":"星期六","sunrise":"06:46","sunset":"17:04","aqi":59,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08","high":"高温 19℃","low":"低温 11℃","ymd":"2020-11-08","week":"星期日","sunrise":"06:47","sunset":"17:03","aqi":81,"fx":"西南风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","high":"高温 20℃","low":"低温 11℃","ymd":"2020-11-09","week":"星期一","sunrise":"06:48","sunset":"17:02","aqi":81,"fx":"西风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"10","high":"高温 21℃","low":"低温 12℃","ymd":"2020-11-10","week":"星期二","sunrise":"06:49","sunset":"17:01","aqi":69,"fx":"西风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"11","high":"高温 22℃","low":"低温 12℃","ymd":"2020-11-11","week":"星期三","sunrise":"06:50","sunset":"17:00","aqi":76,"fx":"东北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 18℃","low":"低温 10℃","ymd":"2020-11-12","week":"星期四","sunrise":"06:51","sunset":"17:00","aqi":57,"fx":"东风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","high":"高温 21℃","low":"低温 10℃","ymd":"2020-11-13","week":"星期五","sunrise":"06:52","sunset":"16:59","aqi":67,"fx":"东南风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
         * yesterday : {"date":"29","high":"高温 19℃","low":"低温 8℃","ymd":"2020-10-29","week":"星期四","sunrise":"06:36","sunset":"17:14","aqi":88,"fx":"西南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"}
         */
        var shidu: String? = null
        var pm25 = 0.0
        var pm10 = 0.0
        var quality: String? = null
        var wendu: String? = null
        var ganmao: String? = null
        var yesterday: YesterdayBean? = null
        var forecast: List<ForecastBean>? = null

        class YesterdayBean {
            /**
             * date : 29
             * high : 高温 19℃
             * low : 低温 8℃
             * ymd : 2020-10-29
             * week : 星期四
             * sunrise : 06:36
             * sunset : 17:14
             * aqi : 88
             * fx : 西南风
             * fl : 2级
             * type : 阴
             * notice : 不要被阴云遮挡住好心情
             */
            var date: String? = null
            var high: String? = null
            var low: String? = null
            var ymd: String? = null
            var week: String? = null
            var sunrise: String? = null
            var sunset: String? = null
            var aqi = 0
            var fx: String? = null
            var fl: String? = null
            var type: String? = null
            var notice: String? = null
        }

        class ForecastBean {
            /**
             * date : 30
             * high : 高温 20℃
             * low : 低温 11℃
             * ymd : 2020-10-30
             * week : 星期五
             * sunrise : 06:37
             * sunset : 17:13
             * aqi : 95
             * fx : 南风
             * fl : 2级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */
            var date: String? = null
            var high: String? = null
            var low: String? = null
            var ymd: String? = null
            var week: String? = null
            var sunrise: String? = null
            var sunset: String? = null
            var aqi = 0
            var fx: String? = null
            var fl: String? = null
            var type: String? = null
            var notice: String? = null
        }
    }
}