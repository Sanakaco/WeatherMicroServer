package com.kin.city.controller;

import com.kin.city.service.CityService;
import com.kin.common.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author pandas
 * @ClassName CityController
 * @Description TODO
 * @create 2019/11/28 17:55
 */
@RestController
public class CityController {
    @Autowired
    private CityService service;

    @GetMapping(value = "/citylist")
    public List<City> getCity() throws FileNotFoundException {
        List<City> cityList = service.getCityList();
        return cityList;
    }
}
