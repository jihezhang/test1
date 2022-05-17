package com.ithiema.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithiema.dao.BookDao;
import com.ithiema.domain.Book;
import com.ithiema.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public IPage<Book> selectPage(long currentPage, long pageSize) {
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> selectPage(long pages, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page<Book>(pages, pageSize);
        bookDao.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
