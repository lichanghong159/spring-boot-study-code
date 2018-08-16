package com.lch.spring.cloud.server.controlle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichanghong on 2018-08-06
 **/
@RestController
public class ServerController {
    @RequestMapping("/say")
    public String say(@RequestParam String message){
        System.out.println("接收到的消息say->"+message);
        return "收到消息->"+message;
    }
}
