package com.kaitoshy.demo.repository;

import com.kaitoshy.demo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository{
    /**
     * Create table if not exist.
     *
     * @throws SQLException SQL exception
     */
    void createTableIfNotExists() throws SQLException;
    
   
    Long insert(User user) throws SQLException;
    
   
    List<User> selectAll() throws SQLException;
}
