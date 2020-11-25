package com.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner.class, args);
    }
}