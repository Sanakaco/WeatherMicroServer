package com.kin.web.service.impl;

import com.kin.common.entity.ForecastWeather;
import com.kin.web.service.WeatherFeign;
import com.kin.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pandas
 * @ClassName WebServiceImpl
 * @Description TODO
 * @create 2019/11/29 12:45
 */
@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WeatherFeign feign;

    public ForecastWeather get(String cityid) {
        return feign.get(cityid);
    }
}
