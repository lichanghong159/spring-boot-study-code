package com.lch.services.spring.cloud.ds.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lichanghong on 2018-08-05
 **/
@RestController
public class DemoController {
    @Autowired
    DiscoveryClient discoveryClient;
    @RequestMapping(value = "/services")
    public List<String> getServices(){
        return discoveryClient.getServices();
    }
    @RequestMapping(value = "/services/{name}")
    public List<String> getServiceInstance(@PathVariable String name){
      /*  return     discoveryClient.getInstances(name).stream().map(instance->{
            return instance.getHost()+":"+instance.getPort()+"->"+instance.getUri();
        }).collect(Collectors.toList()); */
        return     discoveryClient.getInstances(name).stream().map(instance->
             instance.getHost()+":"+instance.getPort()+"->"+instance.getUri()
        ).collect(Collectors.toList());
    }
}
