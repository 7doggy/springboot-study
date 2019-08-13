package com.lichun.springboot.springbootstudy.controller.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "special")
@Component
public class SpecialProperties {
    private String name;
    private String age;
}
