package com.ithiema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ithiema.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean deleteById(Integer id);
    Book getById(Integer id);
    List<Book> selectAll();
    IPage<Book> getPage(long currentPage, long pageSize);
    List<Book> selectByCondition(String name);
}
