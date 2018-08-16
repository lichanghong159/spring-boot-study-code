package com.lch.bootstarp;

import com.lch.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: lichanghong on 2018-07-19
 **/
@SpringBootApplication
public class ApplicationBootStarp {
    /**
     * 启动方式
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 启动方式一
         */
       // SpringApplication.run(ApplicationBootStarp.class,args);

        /**
         * 第二种方式，
         */
       /* new SpringApplicationBuilder(ApplicationBootStarp.class)
                .properties("server.port=0")//启动时采取随机端口方式。可以用于测试
                .run(args);*/
        /**
         * 第三种启动方式
         */
        SpringApplication application = new SpringApplication(ApplicationBootStarp.class);
        Map<String,Object> propertisMap = new LinkedHashMap<>();
        propertisMap.put("server.port",0);
        application.setDefaultProperties(propertisMap);
        ConfigurableApplicationContext context=application.run(args);
        System.out.println(context.getBean(ApplicationBootStarp.class));
    }
}
