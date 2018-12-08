package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author zhangyi  2018-12-03-20:52
 * @description
 */
@Slf4j
@Controller
public class TestController {


    @RequestMapping(value = "/index")
    public String index() throws Exception{
        return "sssssss" ;
    }

}
