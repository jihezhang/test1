package cn.itcast.autoConfig;

import cn.itcast.interceptor.SpringMvcConfig;
import cn.itcast.properties.IpProperties;
import cn.itcast.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import(value = {IpProperties.class, IpCountService.class, SpringMvcConfig.class})
public class IpAutoConfig {
}
