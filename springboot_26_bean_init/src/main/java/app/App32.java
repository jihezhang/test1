package app;

import config.SpringConfig31;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App32 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig31.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("-------------------");
        System.out.println(ctx.getBean("cat"));
        SpringConfig31 springConfig2 = ctx.getBean("springConfig31", SpringConfig31.class);
        System.out.println(springConfig2.cat());
        System.out.println(springConfig2.cat());
        System.out.println(springConfig2.cat());
    }
}
