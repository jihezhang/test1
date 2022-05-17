package com.itheima.config;

import com.itheima.domain.Cat;
import com.itheima.domain.Mouse;
import com.itheima.domain.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(Mouse.class)
public class SpringConfig {
    @Bean
//    @ConditionalOnClass(Mouse.class)
//    @ConditionalOnMissingClass("com.itheima.domain.Wolf")//也需要使用全类名
//    @ConditionalOnClass(name="com.itheima.domain.Mouse")//使用name属性，必须写全类名

    @ConditionalOnBean(name="Jerry")
    public Cat Tom() {
        return new Cat();
    }
}
