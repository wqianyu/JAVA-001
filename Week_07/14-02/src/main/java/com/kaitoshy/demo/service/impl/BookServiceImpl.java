package com.kaitoshy.demo.service.impl;

import com.kaitoshy.demo.entity.Book;
import com.kaitoshy.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author kaito
 * @createDate 2020/12/3 23:57
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    private JdbcTemplate masterJdbcTemplate;
    @Autowired
    private JdbcTemplate slaveJdbcTemplate;
    
    @Override
    public void listBooks() {
        log.info("Count: {}", slaveJdbcTemplate.queryForObject("SELECT COUNT(*) FROM book", Long.class));
        
        List<Book> fooList = slaveJdbcTemplate.query("select * from book", (resultSet, i) -> Book.builder()
                .id(resultSet.getLong(1))
                .name(resultSet.getString(2))
                .isbn(resultSet.getString(3)).build());
        fooList.forEach(f -> log.info("Book: {}", f));
    }
    
    @Override
    public boolean insertBook(final Book book) {
        int book1 = masterJdbcTemplate.update("insert into book(`name`, isbn) values (?, ?)", book.getName(), book.getIsbn());
        if (book1 > 0) {
            log.info("Book:{}", book);
            return true;
        }
      
        return false;
    }
}
