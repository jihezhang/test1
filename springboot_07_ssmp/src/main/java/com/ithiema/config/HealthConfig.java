package com.ithiema.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("itheima", 18);
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("itheima1", "woxihuanta");
        builder.withDetails(stringObjectMap);
//        builder.up();
//        builder.down();
//        builder.outOfService();
//        builder.unknown();
//        builder.status(Status.DOWN);
//        builder.status(Status.OUT_OF_SERVICE);
//        builder.status(Status.UP);
        builder.status(Status.UNKNOWN);
    }
}
