package com.lch.spring.cloud.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: lichanghong on 2018-08-06
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudServerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
