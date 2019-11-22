package com.kin.single.service;

import com.kin.single.weather.Weather;

import java.io.IOException;

/**
 * @author pandas
 * @InterfaceName WeatherReportService
 * @Description TODO
 * @create 2019/11/22 9:52
 */
public interface WeatherReportService {

    Weather getDataByCityid(String cityid) throws IOException;
}
