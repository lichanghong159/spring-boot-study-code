package com.lch.mvc.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: lichanghong on 2018-07-22
 **/
@Controller
public class CacheRestControllerDemo {
    /**
     * 缓存演示
     * @return
     */
    @RequestMapping("/cache")
    public ResponseEntity<String> cache(@RequestParam(required = false,defaultValue = "false") boolean cache){
        ResponseEntity<String> responseEntity ;
        if(cache){
            responseEntity = new ResponseEntity("Hello Word",HttpStatus.NOT_MODIFIED);
        }else{
            responseEntity = new ResponseEntity("Hello Word",HttpStatus.OK);
        }
        return responseEntity;
    }
}
