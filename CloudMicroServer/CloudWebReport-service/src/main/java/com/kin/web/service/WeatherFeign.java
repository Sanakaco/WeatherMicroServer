package com.kin.web.service;

import com.kin.common.entity.ForecastWeather;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author pandas
 * @InterfaceName WeatherFeign
 * @Description TODO
 * @create 2019/11/29 12:43
 */
@FeignClient(value = "cloudreport",fallback = WeatherFeignFallback.class)
public interface WeatherFeign {
    ForecastWeather get(String cityid);
}

class WeatherFeignFallback implements WeatherFeign{
    public ForecastWeather get(String cityid) {
        ForecastWeather weather = new ForecastWeather();
        weather.setStatus("404");
        weather.setInfo("降级处理");
        return weather;
    }
}
