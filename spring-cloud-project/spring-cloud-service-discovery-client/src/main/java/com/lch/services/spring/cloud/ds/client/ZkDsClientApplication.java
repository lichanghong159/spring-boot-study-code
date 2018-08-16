package com.lch.services.spring.cloud.ds.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: lichanghong on 2018-08-04
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkDsClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkDsClientApplication.class,args);
    }
}
