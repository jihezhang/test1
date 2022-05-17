package com.itheima.comfig;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class XmemcachedConfig {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        builder.setOpTimeout(xMemcachedProperties.getOpTimeout());
        MemcachedClient memcachedClient = builder.build();
        return memcachedClient;
    }
}
