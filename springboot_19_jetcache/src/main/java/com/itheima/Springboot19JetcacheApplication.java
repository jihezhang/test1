package com.itheima;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.itheima")
public class Springboot19JetcacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot19JetcacheApplication.class, args);
    }
}
