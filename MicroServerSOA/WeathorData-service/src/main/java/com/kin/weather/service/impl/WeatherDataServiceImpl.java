package com.kin.weather.service.impl;


import com.alibaba.fastjson.JSON;
import com.kin.weather.domain.weather.WeatherResponse;
import com.kin.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

/**
 * @author pandas
 * @ClassName WeatherDataServiceImpl
 * @Description TODO
 * @create 2019/11/20 15:36
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final Logger log= LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    //增加redis,
    @Autowired
    private RedisTemplate redisTemplate;

    private final String WEATHER_API_URI="http://wthrcdn.etouch.cn/weather_mini";

    public WeatherResponse getDataByCityId(String id) throws IOException {
        String url=WEATHER_API_URI+"?citykey="+id;
        return doGetWeatherData(url);
    }

    public WeatherResponse getDataByCityName(String name) throws IOException {
        String url=WEATHER_API_URI+"?city="+name;
        return doGetWeatherData(url);
    }


    //这里直接从redis获取数据
    private WeatherResponse doGetWeatherData(String url) throws IOException {
        ValueOperations<String,WeatherResponse> ops=redisTemplate.opsForValue();
        WeatherResponse weatherResponse=null;
        String UKey=url;

        if (!redisTemplate.hasKey(UKey)){
            log.error("key:{} 不存在缓存数据",url);
            throw new RuntimeException(url+" 没有对应城市数据");
        }
        else {
            weatherResponse=ops.get(UKey);
            log.info("key:{} 从缓存取出数据",url);
        }
        return weatherResponse;
    }
}
