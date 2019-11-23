package com.kin.collection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author pandas
 * @ClassName RestTemplateConfig
 * @Description TODO
 * @create 2019/11/22 15:43
 */
@Configuration
public class RestTemplateConfig {
    
    
    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
