package com.itheima.domain;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Data
@Import(CartoonProperties.class)
public class CartoonCatAndMouse implements ApplicationContextAware {
    private Cat cat;
    private Mouse mouse;


    private CartoonProperties cartoonProperties;

    public CartoonCatAndMouse(CartoonProperties cartoonProperties){
        this.cartoonProperties = cartoonProperties;
        cat = new Cat();
        mouse = new Mouse();
        cat.setAge(cartoonProperties.getCat() != null && cartoonProperties.getCat().getAge()!=null ? cartoonProperties.getCat().getAge() : 3);
        cat.setName(cartoonProperties.getCat() != null && cartoonProperties.getCat().getName()!=null ? cartoonProperties.getCat().getName() : "Tom");
        mouse.setAge(cartoonProperties.getMouse() != null && cartoonProperties.getMouse().getAge()!=null ? cartoonProperties.getMouse().getAge() : 4);
        mouse.setName(cartoonProperties.getMouse() != null && cartoonProperties.getMouse().getName()!=null ? cartoonProperties.getMouse().getName() : "Jerry");
    }

    public void play() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(cat.getAge()+"岁的"+ cat.getName()+"和"+ mouse.getAge() +"岁的"+ mouse.getName() +"打起来了");
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
