package com.kin.report.controller;

import com.kin.common.entity.ForecastWeather;
import com.kin.report.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pandas
 * @ClassName ReportController
 * @Description TODO
 * @create 2019/11/28 10:12
 */
@RestController
public class ReportController {

    @Autowired
    private WeatherService service;

    @GetMapping("/report/{cityid}")
    ModelAndView get(@PathVariable("cityid") String cityid){
        ModelAndView modelAndView = new ModelAndView();
        ForecastWeather weather = service.getForecastWeatherByCityid(cityid);
        modelAndView.addObject("weather",weather);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("get/{citycode}")
    String index(){

        return "ok";
    }
}
