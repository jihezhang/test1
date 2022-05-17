package com.itheima.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("itheima", 18);
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("itheima1", "woxihuanta");
        builder.withDetails(stringObjectMap);
    }
}
