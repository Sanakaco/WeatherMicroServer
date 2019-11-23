package com.kin.weather.domain.weather;

import java.io.Serializable;
import java.util.List;

/**
 * @author pandas
 * @ClassName Weather
 * @Description TODO
 * @create 2019/11/20 14:29
 */
public class Weather implements Serializable {

    private YesterdayWeather yesterday;
    private String city;
    private List<Forcecast> forecast;
    private String ganmao;
    private String wendu;




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayWeather getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayWeather yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forcecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forcecast> forecast) {
        this.forecast = forecast;
    }
}
