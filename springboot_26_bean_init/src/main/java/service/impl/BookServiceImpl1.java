package service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl1 implements BookService {

    public void check() {
        System.out.println("check 1..");
    }
}
