package com.kin.single.service;

import com.kin.single.weather.WeatherResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * @author pandas
 * @InterfaceName WeatherDataService
 * @Description TODO
 * @create 2019/11/20 15:33
 */
public interface WeatherDataService {

    /**
     *@Method getDataByCityId
     *@Description 通过城市ID查询天气数据
     *@author pandas
     *@create 2019/11/20 15:34
     *@Param [id]
     *@return com.kin.single.weather.WeatherResponse
     */
    WeatherResponse getDataByCityId(String id) throws IOException;

    /**
     *@Method getDataByCityName
     *@Description 通过城市名称查询数据
     *@author pandas
     *@create 2019/11/20 15:35
     *@Param [name]
     *@return com.kin.single.weather.WeatherResponse
     */
    WeatherResponse getDataByCityName(String name) throws IOException;
}
