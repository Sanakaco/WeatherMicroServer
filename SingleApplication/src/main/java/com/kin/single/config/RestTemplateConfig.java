package com.kin.single.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author pandas
 * @ClassName RestTemplateConfig
 * @Description TODO
 * @create 2019/11/21 10:50
 */
@Configuration
public class RestTemplateConfig {
    //引入resttemplate Bean
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
}
