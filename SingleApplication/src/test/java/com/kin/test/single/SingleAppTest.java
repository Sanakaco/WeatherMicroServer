package com.kin.test.single;

import com.alibaba.fastjson.JSON;
import com.kin.single.weather.WeatherResponse;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

/**
 * @author pandas
 * @ClassName SingleAppTest
 * @Description TODO
 * @create 2019/11/20 16:53
 */

public class SingleAppTest {

    RestTemplate restTemplate=new RestTemplate();


    @Test
    public void test() throws IOException {

        //返回类型application/octet-stream,并经过gzip打包，这里需要将response解压
        ResponseEntity<byte[]> responseEntity=restTemplate.getForEntity("http://wthrcdn.etouch.cn/weather_mini?citykey=101210101",byte[].class);


        GZIPInputStream gzip=new GZIPInputStream(new ByteArrayInputStream(responseEntity.getBody()));
        BufferedReader reader=new BufferedReader(new InputStreamReader(gzip));
        StringWriter writer=new StringWriter();
        String line;
        while ((line=reader.readLine())!=null){
            writer.write(line);
        }
        String res=writer.toString();
        WeatherResponse weatherResponse= JSON.parseObject(res,WeatherResponse.class);
        System.out.println(res);
        System.out.println(weatherResponse.toString());
    }

}
