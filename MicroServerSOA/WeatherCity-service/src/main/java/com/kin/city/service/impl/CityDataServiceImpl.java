package com.kin.city.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kin.city.domain.city.CityMsg;
import com.kin.city.service.CityDataService;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName CityDataServiceImpl
 * @Description TODO
 * @create 2019/11/21 11:11
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    public List<CityMsg> listCity() throws IOException {
        ClassPathResource resource=new ClassPathResource("templates/cityTest.json");
        File file=resource.getFile();
        String input= FileUtils.readFileToString(file,"UTF-8");
        JSONArray jsonArray= JSON.parseArray(input);
        List<CityMsg> cityMsgs=jsonArray.toJavaList(CityMsg.class);
        return cityMsgs;
    }
}
