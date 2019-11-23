package com.kin.weather.domain.weather;

/**
 * @author pandas
 * @ClassName Forcecast
 * @Description TODO
 * @create 2019/11/20 14:32
 */
public class Forcecast {
    private static final long versionUid=1l;
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public static long getVersionUid() {
        return versionUid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }



    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
