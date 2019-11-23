package com.kin.cloud.cityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pandas
 * @ClassName CityApplication
 * @Description TODO
 * @create 2019/11/23 15:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class,args);
    }
}
