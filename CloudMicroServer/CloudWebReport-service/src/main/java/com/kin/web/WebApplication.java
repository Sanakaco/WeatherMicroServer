package com.kin.web;

import jdk.nashorn.internal.runtime.ArgumentSetter;
import org.apache.catalina.loader.WebappClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author pandas
 * @ClassName WebApplication
 * @Description TODO
 * @create 2019/11/29 12:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
