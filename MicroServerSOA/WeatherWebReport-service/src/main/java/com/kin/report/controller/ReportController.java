package com.kin.report.controller;

import com.alibaba.fastjson.JSONArray;
import com.kin.report.domain.city.CityMsg;
import com.kin.report.domain.weather.Weather;
import com.kin.report.service.WeatherReportService;
import com.kin.report.service.impl.WeatherReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName ReportController
 * @Description TODO
 * @create 2019/11/22 19:51
 */
@RestController
@RequestMapping(value = "/result")
public class ReportController {


    private final String CITY_SERVICE_URL="http://localhost:9002/city/list";

    @Autowired
    private RestTemplate template;
    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping(value = "/cityid/{cityid}")
    public ModelAndView getWheather(@PathVariable("cityid") String cityid) throws IOException {
        ResponseEntity<JSONArray> entity = template.getForEntity(CITY_SERVICE_URL, JSONArray.class);
        List<CityMsg> cityMsgs = entity.getBody().toJavaList(CityMsg.class);
        Weather weather=weatherReportService.getDataByCityid(cityid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityid",cityid);
        modelAndView.addObject("cityList",cityMsgs);
        modelAndView.addObject("report",weather);
        modelAndView.setViewName("report");
        return modelAndView;
    }
    @GetMapping("test/{cityid}")
    public Weather test(@PathVariable("cityid") String cityid) throws IOException {
        return weatherReportService.getDataByCityid(cityid);
    }

    @GetMapping("test1")
    public ModelAndView test1(){
        ResponseEntity<JSONArray> entity = template.getForEntity(CITY_SERVICE_URL, JSONArray.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("citylist");
        modelAndView.addObject("cityList",entity.getBody());
        return modelAndView;
    }
}
