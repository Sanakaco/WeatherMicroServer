package com.kin.city.controller;

import com.kin.city.domain.city.CityMsg;
import com.kin.city.service.impl.CityDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName CityController
 * @Description TODO
 * @create 2019/11/22 16:40
 */
@RequestMapping("/city")
@RestController
public class CityController {

    @Autowired
    private CityDataServiceImpl cityDataService;

    @GetMapping("/list")
    public List<CityMsg> getCityList() throws IOException {
        return cityDataService.listCity();
    }
}
