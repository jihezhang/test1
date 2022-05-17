package app;

import config.SpringConfig7;
import config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class App8 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookService bookService = ctx.getBean("bookService", BookService.class);
        bookService.check();
    }
}
