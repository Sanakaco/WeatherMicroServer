package com.kin.single.service.impl;

import com.alibaba.fastjson.JSON;
import com.kin.single.service.WeatherDataService;
import com.kin.single.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
    private final int TIMEOUT=1800;

    @Autowired
    private RestTemplate restTemplate;

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


    private WeatherResponse doGetWeatherData(String url) throws IOException {
        ValueOperations<String,WeatherResponse> ops=redisTemplate.opsForValue();
        WeatherResponse weatherResponse=null;
        String UKey=url;
        if (!redisTemplate.hasKey(UKey)) {
            System.out.println("没有找到该城市天气信息");
            ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
            if (responseEntity.getStatusCodeValue() != 200) {
                return null;
            }
            GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(responseEntity.getBody()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(gzip));
            StringWriter writer = new StringWriter();
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            String res = writer.toString();
            weatherResponse = JSON.parseObject(res, WeatherResponse.class);
            //如果不存在缓存，则设置该城市天气数据并设置30分钟的超时时间
            ops.setIfAbsent(UKey,weatherResponse,TIMEOUT, TimeUnit.SECONDS);
            return weatherResponse;
        }
        else {
            System.out.println("存在缓存数据");
            weatherResponse=ops.get(UKey);
            return weatherResponse;
        }
    }
}
