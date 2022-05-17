package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(configuration.class)
public class MsgConfigurationTest {

    @Autowired
    private String msg;

    @Test
    public void test(){
        System.out.println(msg);
    }
}
