package com.lch.spring.cloud.stream.rabbitMq;

import com.lch.spring.cloud.stream.rabbitMq.service.SimpleMessageService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author: lichanghong on 2018-08-16
 **/
@SpringBootApplication
@EnableBinding(SimpleMessageService.class)
public class SpringCloudClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudClientApplication.class).web(WebApplicationType.SERVLET)
                .run(args);
    }
}
