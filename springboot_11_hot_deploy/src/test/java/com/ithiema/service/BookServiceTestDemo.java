package com.ithiema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ithiema.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestDemo {

    @Autowired
    private BookService bookService;

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("chensiyuan");
        book.setType("ceshi");
        book.setDescription("jiushiniubi");
        System.out.println(bookService.save(book));
    }

    @Test
    public void testSelectPage() {
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page);
    }

    @Test
    public void testSelectByCondition() {
        String name = "chensiyuan";
        List<Book> books = bookService.selectByCondition(name);
        System.out.println(books);
    }
}
