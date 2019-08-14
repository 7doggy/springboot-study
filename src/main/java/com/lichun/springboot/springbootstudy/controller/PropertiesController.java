package com.lichun.springboot.springbootstudy.controller;

import com.lichun.springboot.springbootstudy.controller.config.SpecialProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private Environment env;

    @Value("${special.age}")
    private String age;

    @Autowired
    private SpecialProperties specialProperties;

    @GetMapping("/method1")
    public String getPropertyMethod1() {
        return env.getProperty("special.name");
    }

    @GetMapping("/method2")
    public String getPropertyMethod2() {
        return age;
    }

    @GetMapping("/method3")
    public SpecialProperties getPropertyMethod44444() {
        return specialProperties;
    }

}
