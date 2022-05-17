package com.ithiema.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ithiema.dao.BookDao;
import com.ithiema.domain.Book;
import com.ithiema.service.BookService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(long currentPage, long pageSize) {
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public List<Book> selectByCondition(String name) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Book> bookQueryWrapper = queryWrapper.eq("name", name);
        List<Book> books = bookDao.selectList(bookQueryWrapper);
        return books;
    }
}
