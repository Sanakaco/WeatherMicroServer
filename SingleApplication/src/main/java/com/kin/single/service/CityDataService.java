package com.kin.single.service;

import com.kin.single.city.CityMsg;

import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @InterfaceName CityDataService
 * @Description TODO
 * http://api.k780.com:88/?app=weather.city&cou=1
 * 获取所有城市列表信息
 * @create 2019/11/21 9:01
 */
public interface CityDataService {
    List<CityMsg> listCity() throws IOException;
}
