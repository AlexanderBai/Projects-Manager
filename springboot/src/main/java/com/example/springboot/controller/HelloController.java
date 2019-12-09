package com.example.springboot.controller;

import com.example.springboot.pojo.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-9下午2:54
 **/
@RestController
public class HelloController {

    private static final String template = "Hello,%s";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
