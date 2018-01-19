package com.keenness.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cj
 * @create 2018-01-19 11:13
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class AdminApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminApplication.class).run(args);
    }
}
