package com.ithiema.controller;

import cn.itcast.service.IpCountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ithiema.controller.utils.R;
import com.ithiema.domain.Book;
import com.ithiema.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        List<Book> list = iBookService.list();
        return new R(true, list);
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean flag = iBookService.removeById(id);
        return new R(flag);
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(iBookService.updateById(book));
    }

    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("1234")) throw new Exception();
        boolean flag = iBookService.save(book);
        return new R(flag, flag ? "添加成功！！！" : "添加失败！！！");
    }



    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {

        IPage<Book> page = iBookService.selectPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = iBookService.selectPage(page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, iBookService.getById(id));
    }
}
