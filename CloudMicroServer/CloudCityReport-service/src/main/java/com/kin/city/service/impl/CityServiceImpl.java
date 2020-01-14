package com.kin.city.service.impl;

import com.kin.city.service.CityService;
import com.kin.common.entity.City;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pandas
 * @ClassName CityServiceImpl
 * @Description TODO
 * @create 2019/11/28 17:16
 */
@Service
public class CityServiceImpl implements CityService {
    public List<City> getCityList() throws FileNotFoundException {
        List<City> cities = new ArrayList<City>();
        String filepath="D:\\Users\\githubResource\\WeatherMicroServer\\CloudMicroServer\\CloudCityReport-service\\src\\main\\resources\\AMap_adcode_citycode.xlsx";

        File execl = new File(filepath);
        String addName; String adcode; String citycode;

        try {
            //读取城市编号文件
            FileInputStream inputStream=new FileInputStream(execl);
            XSSFWorkbook sheets = new XSSFWorkbook(inputStream);
            Sheet sheet=sheets.getSheetAt(0);
            int firstIndex =sheet.getFirstRowNum()+2;
            int lastIndex =sheet.getLastRowNum()-1;
            //将每一行数据放入集合集体返回
            for (int index=firstIndex;index<lastIndex;index++){
                Row row=sheet.getRow(index);
                addName=row.getCell(0).toString();
                adcode=row.getCell(1).toString();
                cities.add(new City(addName,adcode));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public String getAdCodeByName(String adname) {

        return null;
    }
}
