package com.kin.common.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pandas
 * @ClassName ForecastWeather
 * @Description TODO
 * @create 2019/11/28 15:42
 */
@Data
public class ForecastWeather {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<Forecasts> forecasts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<Forecasts> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecasts> forecasts) {
        this.forecasts = forecasts;
    }
}

@Data
class Forecasts{
    private String city;
    private String adcode;
    private String province;
    private String reporttime;
    private List<Casts> casts;

}

@Data
class Casts{
    private String date;
    private String week;
    private String dayweather;
    private String nightweather;
    private String daytemp;
    private String nighttemp;
    private String daywind;
    private String nightwind;
    private String daypower;
    private String nightpower;
}