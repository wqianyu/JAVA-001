package com.kaitoshy.demo;

import com.kaitoshy.demo.entity.Book;
import com.kaitoshy.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
@Slf4j
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private BookService bookService;
    
  
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Override
    public void run(final String... args) throws Exception {
        Book book = Book.builder().name("Java编程思想").isbn("22222222").build();
        bookService.insertBook(book);
        
        bookService.listBooks();
    }
    
    
    
   
}
