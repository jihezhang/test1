package com.itheima.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheCode {

    @Cacheable(value= "SIMCache", key="#tele")
    public String get(String tele) {
        return null;
    }

}
