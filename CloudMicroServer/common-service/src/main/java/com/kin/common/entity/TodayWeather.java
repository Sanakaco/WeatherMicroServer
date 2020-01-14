package com.kin.common.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pandas
 * @ClassName TodayWeather
 * @Description TODO
 * @create 2019/11/28 15:16
 */
@Data
public class TodayWeather {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<Lives> lives;
}

@Data
class Lives{
    private String province;
    private String city;
    private String adcode;
    private String weather;
    private String temperature;
    private String winddirection;
    private String windpower;
    private String humidity;
    private String reporttime;
}