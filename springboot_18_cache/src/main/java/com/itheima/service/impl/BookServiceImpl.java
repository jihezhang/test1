package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;

    private HashMap<Integer, Book> cache = new HashMap<>();

    @Override
    public Book getById1(Integer id) {
        Book book = cache.get(id);
        if (book == null) {
            Book queryBook = bookDao.selectById(id);
            cache.put(id, queryBook);
            return queryBook;
        }
        return cache.get(id);
    }
}
