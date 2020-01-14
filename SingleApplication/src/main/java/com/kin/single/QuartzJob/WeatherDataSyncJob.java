package com.kin.single.QuartzJob;

import com.kin.single.city.CityMsg;
import com.kin.single.service.CityDataService;
import com.kin.single.service.SyncWeatherDataService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    private CityDataService cityDataService;


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("123");
        executeTask();
    }

    private void executeTask(){

        try {
            List<CityMsg> cityMsgs=cityDataService.listCity();
            String cityid;
            for (CityMsg cityMsg: cityMsgs){
                cityid=cityMsg.getCity_code();
                syncWeatherDataService.syncDataByCityid(cityid);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
