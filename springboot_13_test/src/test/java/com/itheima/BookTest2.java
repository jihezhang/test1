package com.itheima;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"book.name=springboot"})
public class BookTest2 {
    @Value("${book.name}")
    @Autowired
    private String msg;

    @Test
    public void testBook2(){
        System.out.println(msg);
    }
}
