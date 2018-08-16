package com.lch.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lichanghong on 2018-08-01
 **/
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServer.class, args);
    }
    //自定义实现
    @Bean
    public  EnvironmentRepository environmentRepository(){
       /* EnvironmentRepository environmentRepository = new EnvironmentRepository() {
            @Override
            public Environment findOne(String application, String profile, String label) {
                return null;
            }
        };*/
        return (String application, String profile, String label)->{
            Environment environment = new Environment("default",profile);
            List<PropertySource> propertySources = environment.getPropertySources();
            Map<String,Object> source = new HashMap<>();
            source.put("name","李长红");
            PropertySource propertySource = new PropertySource("map",source);
            propertySources.add(propertySource);
            return environment;
        };
    }
}
