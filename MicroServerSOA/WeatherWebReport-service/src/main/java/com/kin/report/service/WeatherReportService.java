package com.kin.report.service;


import com.kin.report.domain.weather.Weather;

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
