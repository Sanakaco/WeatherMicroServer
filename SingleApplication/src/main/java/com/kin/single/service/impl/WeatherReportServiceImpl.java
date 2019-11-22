package com.kin.single.service.impl;

import com.kin.single.service.WeatherReportService;
import com.kin.single.weather.Weather;
import com.kin.single.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author pandas
 * @ClassName WeatherReportServiceImpl
 * @Description TODO
 * @create 2019/11/22 9:53
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataServiceImpl dataService;
    public Weather getDataByCityid(String cityid) throws IOException {
        WeatherResponse response=dataService.getDataByCityId(cityid);
        return response.getData();
    }
}
