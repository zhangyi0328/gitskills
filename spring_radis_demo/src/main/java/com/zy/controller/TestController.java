package com.zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:zhangyi
 * time: 2018/4/30 22:18
 */

@Controller
@RequestMapping(value = "/demo")
public class TestController {

    @RequestMapping(value = "/welecome")
    public String a () {
      //  System.out.println("2222");
        return "welecom" ;
    }
}
