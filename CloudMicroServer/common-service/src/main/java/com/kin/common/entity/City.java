package com.kin.common.entity;

import lombok.Data;

/**
 * @author pandas
 * @ClassName City
 * @Description TODO
 * @create 2019/11/28 17:13
 */
@Data
public class City {
    private String addName;
    private String adcode;


    public City(String addName, String adcode) {
        this.addName = addName;
        this.adcode = adcode;
    }
}
