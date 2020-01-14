package com.kin.report;

import com.netflix.hystrix.Hystrix;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author pandas
 * @ClassName ReportApplication
 * @Description TODO
 * @create 2019/11/28 10:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
public class ReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class,args);
    }





}
