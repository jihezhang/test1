package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class DaoTest {
    @Autowired
    private BookService bookService;
    @Test
    void testSave() {
        Book book = new Book();
        book.setType("springboot1");
        book.setDescription("springboot1");
        book.setName("springboot1");
        System.out.println(book);
        bookService.save(book);
    }
}
