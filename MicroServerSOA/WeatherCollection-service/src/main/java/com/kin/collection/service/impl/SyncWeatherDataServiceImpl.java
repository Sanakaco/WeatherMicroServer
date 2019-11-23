package com.kin.collection.service.impl;


import com.alibaba.fastjson.JSON;
import com.kin.collection.domain.weather.WeatherResponse;
import com.kin.collection.service.SyncWeatherDataService;
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
 * @ClassName SyncWeatherDataServiceImpl
 * @Description TODO
 * @create 2019/11/21 11:15
 */
@Service
public class SyncWeatherDataServiceImpl implements SyncWeatherDataService {
    private final Logger log= LoggerFactory.getLogger(SyncWeatherDataServiceImpl.class);

    private final String WEATHER_API_URI="http://wthrcdn.etouch.cn/weather_mini";

    private final int TIMEOUT=1800;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public void syncDataByCityid(String cityid) throws IOException {
        doGetDataByCityid(cityid);
    }

    private void doGetDataByCityid(String cityid) throws IOException {
        log.info("开始获取天气数据,CityID:[{}]",cityid);
        String url=WEATHER_API_URI+"?citykey="+cityid;
        ValueOperations<String, WeatherResponse> ops=redisTemplate.opsForValue();
        WeatherResponse weatherResponse=null;
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        if (responseEntity.getStatusCodeValue() != 200) {
            log.error("[{}]城市天气数据获取数据失败，响应码:[{}]",cityid,responseEntity.getStatusCode());
            return ;
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
        ops.set(url,weatherResponse,TIMEOUT, TimeUnit.SECONDS);
        log.info("[{}] 数据刷新完成",cityid);
    }
}
