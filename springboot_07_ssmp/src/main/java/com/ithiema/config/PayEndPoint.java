package com.ithiema.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay(){
        Map payMap = new HashMap();
        payMap.put("level1",100);
        payMap.put("level2",200);
        payMap.put("level3",300);
        payMap.put("level4",400);

        return payMap;
    }
}
