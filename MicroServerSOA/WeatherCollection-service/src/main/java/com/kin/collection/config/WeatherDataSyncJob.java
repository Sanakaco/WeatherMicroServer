package com.kin.collection.config;


import com.alibaba.fastjson.JSON;
import com.kin.collection.domain.city.CityMsg;
import com.kin.collection.service.SyncWeatherDataService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName WeatherDataSyncJob
 * @Description TODO同步天气数据
 * @create 2019/11/20 21:28
 */

public class WeatherDataSyncJob implements Job {


    @Autowired
    private SyncWeatherDataService syncWeatherDataService;

    //采用http调用WeatherCity-Service的服务
    //url:http://localhost:9002/city/list
    @Autowired
    private RestTemplate template;


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            executeTask();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeTask() throws IOException{

        String url="http://localhost:9002/city/list";
        try {
            ResponseEntity<String> entity = template.getForEntity(url, String.class);
            List<CityMsg> cityMags = JSON.parseArray(entity.getBody(),CityMsg.class);
            String cityid;
            for (CityMsg cityMsg: cityMags){
                cityid=cityMsg.getCity_code();
                syncWeatherDataService.syncDataByCityid(cityid);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
