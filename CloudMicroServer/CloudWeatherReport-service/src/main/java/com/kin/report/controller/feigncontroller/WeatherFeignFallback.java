package com.kin.report.controller.feigncontroller;

import com.kin.report.controller.feigncontroller.WeatherFeign;
import org.springframework.stereotype.Component;

/**
 * @author pandas
 * @ClassName WeatherFeignFallback
 * @Description TODO
 * @create 2019/11/28 12:19
 */
@Component
public class WeatherFeignFallback implements WeatherFeign {

    public String get(String cityid) {
        return "Hystrix Fallback";
    }
}
