package com.lichun.springboot.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

}
