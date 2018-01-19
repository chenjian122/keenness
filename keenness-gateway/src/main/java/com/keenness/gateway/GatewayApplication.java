package com.keenness.gateway;

import com.keenness.gateway.config.IUserPrincipal;
import com.keenness.gateway.config.UserPrincipal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author cj
 * @create 2018-01-18 9:56
 **/
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).run(args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
