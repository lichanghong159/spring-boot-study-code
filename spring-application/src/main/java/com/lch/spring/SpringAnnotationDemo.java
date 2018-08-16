package com.lch.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lichanghong on 2018-07-19
 **/
@Configuration
public class SpringAnnotationDemo {


    public static void main(String[] args) {
        //xml配置文件驱动  ClassPathXmlApplicationContext
        //Annotation驱动 注解驱动
        /**
         * 不论是xml配置文件驱动 （ClassPathXmlApplicationContext）还是Annotation驱动的(AnnotationConfigApplicationContext)
         * 都会先找到beanDefinition
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册一个Configuration class = SpringAnnotationDemo
        context.register(SpringAnnotationDemo.class);
        //上下文启动
        context.refresh();
        System.out.println(context.getBean(SpringAnnotationDemo.class));
    }

}
