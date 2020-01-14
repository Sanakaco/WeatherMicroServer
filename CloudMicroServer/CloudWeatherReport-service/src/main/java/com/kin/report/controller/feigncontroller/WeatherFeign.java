package com.kin.report.controller.feigncontroller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pandas
 * @InterfaceName WeatherFeign
 * @Description TODO
 * @create 2019/11/28 9:59
 */

@FeignClient(value = "SpiderService",fallback = WeatherFeignFallback.class)
public interface WeatherFeign {

    @GetMapping("/city/?cityid={cityid}")
    String get(@PathVariable("cityid") String cityid);

}
