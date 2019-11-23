package com.kin.weather.controller;


import com.kin.weather.domain.weather.WeatherResponse;
import com.kin.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author pandas
 * @ClassName WeatherController
 * @Description TODO
 * @create 2019/11/20 15:53
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;


    @GetMapping(value = "/cityid/{cityid}")
    public WeatherResponse getReportByCityId(@PathVariable("cityid") String cityid) throws IOException {

        return weatherDataService.getDataByCityId(cityid);
    }
    @GetMapping(value = "/cityname/{cityname}")
    public WeatherResponse getReportByCityName(@PathVariable("cityname") String cityname) throws IOException {

        return weatherDataService.getDataByCityName(cityname);
    }


}
