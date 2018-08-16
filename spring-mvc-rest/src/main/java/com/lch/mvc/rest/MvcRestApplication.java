package com.lch.mvc.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: lichanghong on 2018-07-22
 **/
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.lch.mvc.rest.controller"})
public class MvcRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MvcRestApplication.class,args);
    }
}
