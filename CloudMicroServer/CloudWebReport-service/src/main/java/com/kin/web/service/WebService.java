package com.kin.web.service;

import com.kin.common.entity.ForecastWeather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pandas
 * @InterfaceName WebService
 * @Description TODO
 * @create 2019/11/29 12:36
 */

public interface WebService {
    ForecastWeather get(String cityid);
}
