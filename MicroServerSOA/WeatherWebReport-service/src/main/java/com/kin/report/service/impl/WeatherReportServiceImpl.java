package com.kin.report.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.kin.report.domain.weather.Weather;
import com.kin.report.domain.weather.WeatherResponse;
import com.kin.report.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author pandas
 * @ClassName WeatherReportServiceImpl
 * @Description TODO
 * @create 2019/11/22 9:53
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    private final String WEATER_COLLECTION_URL="http://localhost:9001/weather/cityid/";
    @Autowired
    private RestTemplate template;

    public Weather getDataByCityid(String cityid) throws IOException {
        String url=WEATER_COLLECTION_URL+cityid;
        ResponseEntity<WeatherResponse> entity = template.getForEntity(url,WeatherResponse.class);

        return entity.getBody().getData();
    }
}
