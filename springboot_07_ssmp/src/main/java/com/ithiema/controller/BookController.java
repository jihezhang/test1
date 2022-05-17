package com.ithiema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ithiema.domain.Book;
import com.ithiema.service.BookService;
import com.ithiema.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll() {
        List<Book> list = iBookService.list();
        for (Book book : list) {
            System.out.println(book);
        }
        return list;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        boolean b = iBookService.removeById(id);
        return b;
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        boolean b = iBookService.updateById(book);
        return b;
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        boolean b = iBookService.save(book);
        return b;
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return iBookService.selectPage(currentPage, pageSize);
    }
}
