package com.john.test.junit.controller;

import com.john.test.junit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name);
    }
}
