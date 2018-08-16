package com.lch.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichanghong on 2018-07-29
 **/
@EnableAutoConfiguration
@RestController
public class SpringBootApplicationBootstrap1 {
    public static void main(String[] args) {
       // SpringApplication.run(SpringBootApplicationBootstrap.class,args);
        //替换写法
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean("HelloWorld",String.class,"Hello,World");//在父类上下文注册一个Bean
        context.setId("lch");
        context.refresh();
        new SpringApplicationBuilder(SpringBootApplicationBootstrap1.class)
                .parent(context)//显式地设置双亲上下文
                .run(args);
    }
    //在子类上下文中使用父类上下文注册的bean
    @Autowired
            @Qualifier(value = "HelloWorld")
    String message;
    @RequestMapping(value = {"","/"})
    public String index(){
        return message;
    }
}
