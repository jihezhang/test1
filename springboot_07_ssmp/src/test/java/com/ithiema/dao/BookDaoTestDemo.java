package com.ithiema.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ithiema.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestDemo {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("zhangjihe");
        book.setType("ceshi");
        book.setDescription("jiushiniubi");
        bookDao.insert(book);

    }

    @Test
    void testSelectById() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testGetAll() {
        List<Book> books = bookDao.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void testDelete() {
        bookDao.deleteById(13);
    }

    @Test
    void testUpdateById() {
        Book book = new Book();
        book.setId(13);
        book.setName("zhangchongyang");
        book.setType("ceshiaaaa");
        book.setDescription("jiushiniubi");
        bookDao.updateById(book);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        IPage iPage = bookDao.selectPage(page, null);
    }

    @Test
    void testGetByCondition1() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
        queryWrapper.like("name", "spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetByCondition2() {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<Book>();
        queryWrapper.like(Book::getName, "spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetByCondition3() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<Book>();
        queryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        bookDao.selectList(queryWrapper);
    }
}
