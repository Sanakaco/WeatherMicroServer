package com.kin.web.controller;

import com.kin.common.entity.ForecastWeather;
import com.kin.web.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pandas
 * @ClassName WebServiceController
 * @Description TODO
 * @create 2019/11/29 12:47
 */
@RestController
@RequestMapping("/web")
public class WebServiceController {

    @Autowired
    private WebService service;

    @GetMapping("/city/{cityid}")
    public ForecastWeather index(@PathVariable("cityid") String cityid){
       return service.get(cityid);
    }
}
