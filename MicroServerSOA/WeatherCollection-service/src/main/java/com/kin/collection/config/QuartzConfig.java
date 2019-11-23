package com.kin.collection.config;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pandas
 * @ClassName QuartzConfig
 * @Description TODO
 * @create 2019/11/20 21:35
 */
@Configuration
public class QuartzConfig {
    //1800S 30MIN
    private final int TIME=1800;

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherQuartzJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger sampleJobTrigger(){
        SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(builder)
                .build();
    }
}
