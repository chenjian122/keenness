package com.keenness.es;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author cj
 * @create 2018-01-22 13:47
 **/
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ElasticsearchApplication.class).run(args);
    }
}
