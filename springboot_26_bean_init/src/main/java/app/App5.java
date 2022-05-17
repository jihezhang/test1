package app;

import config.SpringConfig4;
import domain.Cat;
import domain.Dog;
import domain.Mouse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);
        //不带名称
        ctx.register(Mouse.class);
        //带有名称
        ctx.registerBean("Tom", Cat.class, 0);
        ctx.registerBean("Tom", Cat.class, 1);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(ctx.getBean("Tom"));
        //后面的会覆盖前面的
    }
}
