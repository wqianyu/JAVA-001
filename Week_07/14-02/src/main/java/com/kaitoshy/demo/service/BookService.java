package com.kaitoshy.demo.service;


import com.kaitoshy.demo.entity.Book;

/**
 * @author kaito
 * @createDate 2020/12/3 23:58
 */
public interface BookService {
    
    void listBooks();
    
    boolean insertBook(Book book);
}
