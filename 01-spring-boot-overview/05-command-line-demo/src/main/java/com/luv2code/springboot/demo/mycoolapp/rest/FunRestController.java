package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/")
    public String sayHello(){
        return name;
    }

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }

}
