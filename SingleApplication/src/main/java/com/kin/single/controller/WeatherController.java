package com.kin.single.controller;

import com.kin.single.service.CityDataService;
import com.kin.single.service.WeatherDataService;
import com.kin.single.service.WeatherReportService;
import com.kin.single.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping(value = "/cityid/{cityid}")
    public ModelAndView getReportByCityId(@PathVariable("cityid") String cityid) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityid",cityid);
        modelAndView.addObject("cityList",cityDataService.listCity());
        modelAndView.addObject("report",weatherReportService.getDataByCityid(cityid));
        modelAndView.setViewName("report");
        return modelAndView;
    }
    @GetMapping(value = "/cityname/{cityname}")
    public WeatherResponse getReportByCityName(@PathVariable("cityname") String cityname) throws IOException {

        return weatherDataService.getDataByCityName(cityname);
    }


}
