package com.lch.spring.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lichanghong on 2018-08-05
 **/
@SpringBootApplication
@EnableDiscoveryClient//激活服务发现客户端
@EnableScheduling//激活定时调度
public class SpringCloudClientApplication {
    public static void main(String[] args) {
        //SpringApplication.run(SpringCloudClientApplication.class,args);
        new SpringApplicationBuilder(SpringCloudClientApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
