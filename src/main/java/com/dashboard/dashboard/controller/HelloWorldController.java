package com.dashboard.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {

    @GetMapping
    @RequestMapping("hello")
    public String hello() {
        return "hello, world";
    }
}
