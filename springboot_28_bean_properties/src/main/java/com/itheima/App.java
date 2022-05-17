package com.itheima;

import com.itheima.domain.CartoonCatAndMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

//@Import(CartoonCatAndMouse.class)
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        CartoonCatAndMouse bean = context.getBean(CartoonCatAndMouse.class);
        bean.play();
    }
}
