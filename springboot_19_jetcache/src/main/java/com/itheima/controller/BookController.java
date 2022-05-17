package com.itheima.controller;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping
//    public Book getById(Integer id) {
//        Book byId = bookService.getById(id);
//        return byId;
//    }

    @GetMapping("/{id}")
    @Cached(name = "simCache_", key = "#id", expire = 3600)
    public Book get1(@PathVariable Integer id){
        Book book = bookService.getById(id);
        return book;
    }

//    @GetMapping("/{id}")
//    public Book get(@PathVariable Integer id){
//        Book book = bookService.getById1(id);
//        return book;
//    }

    @GetMapping
    public List<Book> getAll() {
        List<Book> books = bookService.list();
        return books;
    }

    @DeleteMapping("/{id}")
    @CacheInvalidate(name = "simCache_", key = "#id")
    public boolean delete(@PathVariable Integer id){
        boolean b = bookService.removeById(id);
        return b;
    }

    @PostMapping
    @CacheUpdate(name = "simCache_", key = "#book.id", value = "#book")
    public boolean save(@RequestBody Book book) {
        boolean b = bookService.save(book);
        return b;
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        boolean b = bookService.updateById(book);
        return b;
    }
}
