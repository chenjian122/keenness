package com.keenness.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cj
 * @create 2018-01-17 16:36
 **/
@EnableEurekaClient
@EnableConfigServer
@EnableAutoConfiguration
public class ConfigServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServiceApplication.class).run(args);
    }
}
