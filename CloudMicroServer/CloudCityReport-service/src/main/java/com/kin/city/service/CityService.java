package com.kin.city.service;

import com.kin.common.entity.City;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author pandas
 * @InterfaceName CityService
 * @Description TODO
 * @create 2019/11/28 17:11
 */
public interface CityService {
    List<City> getCityList() throws FileNotFoundException;

    String getAdCodeByName(String adname);
}
