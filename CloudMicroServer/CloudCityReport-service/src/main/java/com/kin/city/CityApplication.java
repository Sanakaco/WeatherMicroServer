package com.kin.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pandas
 * @ClassName CityApplication
 * @Description TODO
 * @create 2019/11/28 17:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class,args);
    }
}
