package com.itheima.controller;

import com.itheima.domain.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private DataSource dataSource;
    @GetMapping
    public String getById() {
        System.out.println(dataSource);
        System.out.println("springBoot is running...");
        return "SpringBoot is running...";
    }
}
