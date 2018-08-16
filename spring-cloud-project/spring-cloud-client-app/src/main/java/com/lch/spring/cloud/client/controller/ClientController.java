package com.lch.spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: lichanghong on 2018-08-05
 **/
@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    //线程安全
   // private Set<String> serviceNames = new ConcurrentSkipListSet<>();
   // private volatile Set<String> targetUrls = new HashSet<>();
    private volatile Map<String,Set<String>> targetUrlsCache = new HashMap<>();
    @Scheduled(fixedDelay = 10*1000)//10秒更新下缓存
    public void updateInvocationUrlsCache(){
        Map<String, Set<String>> newTargetUrlsCache = new HashMap<>();
        discoveryClient.getServices().forEach(serviceName -> {
            Set<String> newTargetUrls = discoveryClient.getInstances(serviceName) .stream().map(s->
                    s.isSecure()?
                            "https://"+s.getHost()+":"+s.getPort():
                            "http://"+s.getHost()+":"+s.getPort()
            ).collect(Collectors.toSet());
            newTargetUrlsCache.put(serviceName, newTargetUrls);
        });
        this.targetUrlsCache = newTargetUrlsCache;
    }
  /*  //当前应用名称
    @Value("${spring.application.name}")
    private String currentServiceName;
    @Scheduled(fixedDelay = 10*1000)//10秒更新下缓存
    public void updateInvocationUrls(){//更新目标URLS
        Set<String> oldTargetUrls = this.targetUrls;
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(currentServiceName);
        Set<String> newTargetUrls =serviceInstances .stream().map(s->
                s.isSecure()?
              "https://"+s.getHost()+":"+s.getPort():
                        "http://"+s.getHost()+":"+s.getPort()
        ).collect(Collectors.toSet());
        //交换
        this.targetUrls = newTargetUrls;
        oldTargetUrls.clear();
    }*/
    @GetMapping("/invoke/{serviceName}/say")
    public String invokeSay(@PathVariable String serviceName,
            @RequestParam String message){
        //服务器列表
        List<String> targetUrls = new ArrayList<>(this.targetUrlsCache.get(serviceName));//使用targetUrls的快照
        //轮询列表
        //选择其中一台服务器
        int size = targetUrls.size();
        int index = new Random().nextInt(size);
        String targetUrl = targetUrls.get(index);
    //RestTemplate发送请求到服务器
        //输出响应
    return restTemplate.getForObject(targetUrl+"/say?message="+message,String.class);
    }
}
