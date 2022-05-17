package com.ithiema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ithiema.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> selectPage(long currentPage, long pageSize);

    IPage<Book> selectPage(long pages, int pageSize, Book book);
}
