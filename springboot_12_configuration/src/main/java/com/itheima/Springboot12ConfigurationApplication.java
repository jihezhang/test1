package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot12ConfigurationApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		return ds;
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot12ConfigurationApplication.class, args);
		ServerConfig bean = context.getBean(ServerConfig.class);
		System.out.println(bean);
		DruidDataSource bean1 = context.getBean(DruidDataSource.class);
		System.out.println(bean1.getDriverClassName());
	}
}
