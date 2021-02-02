package com.Z.controller;

import com.Z.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Z on 2021/1/22 10:43
 */
//@ResponseBody
//@Controller
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return  car;
    }

    @RequestMapping("/hello1")
    public String handle01(@RequestParam("name") String name) {
        log.info("请求进来了。。。");
        return "Hello, Spring Boot 2!" + "你好： " + name + log.getName();
    }
}
