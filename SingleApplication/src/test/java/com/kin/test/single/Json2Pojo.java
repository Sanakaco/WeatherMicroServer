package com.kin.test.single;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;

import com.kin.single.city.CityMsg;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName Json2Pojo
 * @Description TODO
 * @create 2019/11/21 9:17
 */
public class Json2Pojo {

    @Test
    public void getCity() throws IOException {
        ClassPathResource resource=new ClassPathResource("templates/cityid.json");
        File file=resource.getFile();
        String input= FileUtils.readFileToString(file,"UTF-8");
        JSONArray jsonArray=JSON.parseArray(input);

        List<CityMsg> cityLists=jsonArray.toJavaList(CityMsg.class);
        for (CityMsg cityList:cityLists){

        }



        System.out.println("asd");

    }
}
