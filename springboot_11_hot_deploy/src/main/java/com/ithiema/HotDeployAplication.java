package com.ithiema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotDeployAplication {


    public static void main(String[] args) {
        System.setProperty("spring.restart.enabled","false");
        SpringApplication.run(HotDeployAplication.class, args);
    }

}
