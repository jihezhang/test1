package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/books")
public class test {

/*    @GetMapping
    public String getById(){
        System.out.println("getById");
        return "springboot";
    }*/
@GetMapping
public Book getById(){
    System.out.println("getById");
    Book book = new Book();
    book.setId(1);
    book.setType("springboot");
    book.setDescription("springboot");
    book.setName("springboot");
    return book;
}
}
