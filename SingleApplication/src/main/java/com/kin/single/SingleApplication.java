package com.kin.single;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kin.single.city.CityMsg;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author pandas
 * @ClassName SingleApplication
 * @Description TODO
 * @create 2019/11/20 15:31
 */
@SpringBootApplication
public class SingleApplication {


    public static void main(String[] args) {
        SpringApplication.run(SingleApplication.class,args);


    }

    public static void addCityMsgToRedis() throws IOException {
        RedisTemplate template=new RedisTemplate();
        ValueOperations<String, CityMsg> ops=template.opsForValue();
        ClassPathResource resource=new ClassPathResource("templates/cityid.json");
        File file=resource.getFile();
        String input= FileUtils.readFileToString(file,"UTF-8");
        JSONArray jsonArray= JSON.parseArray(input);

        List<CityMsg> cityMsgs=jsonArray.toJavaList(CityMsg.class);
        String key=null;
        for (CityMsg cityMsg:cityMsgs){
            key=cityMsg.getCity_name();
            ops.set(key,cityMsg);
            key=cityMsg.getCity_code();
            ops.set(key,cityMsg);

        }
    }




}
