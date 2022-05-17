package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

public interface BookService extends IService<Book> {

    Book getById1(Integer id);
}
