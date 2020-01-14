package com.kin.report.service;

import com.kin.common.entity.ForecastWeather;
import com.kin.common.entity.TodayWeather;

/**
 * @author pandas
 * @ClassName WeatherService
 * @Description TODO
 * @create 2019/11/28 16:27
 */
public interface WeatherService {

    TodayWeather getTodayWeatherByCityid(String cityid);

    ForecastWeather getForecastWeatherByCityid(String cityid);
}
