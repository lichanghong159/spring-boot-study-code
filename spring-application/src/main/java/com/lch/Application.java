package com.lch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication application = new SpringApplication(Application.class);
        //
        /**
         * 设置web启动类型,
         * NONE是以非web的方式启动
         * SERVLET 以mvc的方式启动
         * REACTIVE 以webflux的方式启动。
         */
        application.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context= application.run(args);
        System.out.println(context.getBean(Application.class));
    }
}
