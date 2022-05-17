package config;

import domain.Cat;
import domain.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"domain", "config", "service"})
public class SpringConfig31 {

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
