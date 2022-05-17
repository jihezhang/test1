package config;

import domain.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"domain", "config", "service"})
public class SpringConfig {

    @Bean
    public DogFactoryBean dog1(){
        return new DogFactoryBean();
    }
}
