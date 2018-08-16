package com.lch.spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: lichanghong on 2018-08-06
 **/
@RestController
public class ClientController1 {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;//服务发现

    @Value("${spring.application.name}")
    private String applicationName;//当前应用名称

    //发现的服务URL
    private volatile Set<String> targetUrls = new HashSet<>();
    @Scheduled(fixedRate = 10*1000)//10秒更新一次
    private void updateTargetUrls(){//更新目标urls
        Set<String> oldTargetUrls = this.targetUrls;
        Set<String> newTargetUrls = discoveryClient.getInstances(applicationName).stream()
                .map(s->
                    s.isSecure()?
                            "https://"+s.getHost()+":"+s.getPort():
                            "http://"+s.getHost()+":"+s.getPort()
                ).collect(Collectors.toSet());
        //交换
        this.targetUrls = newTargetUrls;
        //帮助GC回收
        oldTargetUrls.clear();
    }
    @RequestMapping(value = "/toSay")
    public String invokeSay(@RequestParam String msg){
        List<String> list = new ArrayList<>(this.targetUrls);
        int index = new Random().nextInt(list.size());
        String targetUrl = list.get(index);
        return restTemplate.getForObject(targetUrl+"/sayHi?msg="+msg,String.class);
    }
    @RequestMapping(value = "/sayHi")
    public String sayHi(@RequestParam String msg){
        System.out.println("接收到参数->"+msg);
        return "收到参数:"+msg;
    }

}
