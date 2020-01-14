package com.kin.report.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kin.common.entity.ForecastWeather;
import com.kin.common.entity.TodayWeather;
import com.kin.report.controller.feigncontroller.WeatherFeign;
import com.kin.report.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pandas
 * @ClassName WeatherServiceImpl
 * @Description TODO
 * @create 2019/11/28 16:29
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherFeign weatherFeign;

    public TodayWeather getTodayWeatherByCityid(String cityid) {
        return null;
    }

    public ForecastWeather getForecastWeatherByCityid(String cityid) {
        String weaStr = weatherFeign.get(cityid);
        JSONObject json = JSON.parseObject(weaStr);
        ForecastWeather forecastWeather = json.toJavaObject(ForecastWeather.class);
        return forecastWeather;
    }
}
