package com.ithiema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ithiema.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestDemo2 {

    @Autowired
    private IBookService iBookService;

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("chensiyuan");
        book.setType("ceshi");
        book.setDescription("jiushiniubi");
        System.out.println(iBookService.save(book));
    }

    @Test
    public void testSelectPage() {
        IPage<Book> page = new Page<>(1, 5);
        System.out.println(iBookService.page(page));
    }
}
