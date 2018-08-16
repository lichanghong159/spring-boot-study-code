package com.lch.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichanghong on 2018-07-21
 **/
@Controller
public class IndexController {
    @GetMapping({"/",""})
    public String index(Model model){
        model.addAttribute("message","hello word");
        return "index";
    }
}
