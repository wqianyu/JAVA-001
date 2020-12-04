
package com.kaitoshy.demo.service;


import com.kaitoshy.demo.entity.User;
import com.kaitoshy.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Slf4j
public class UserService {
    
    @Resource
    private UserRepository userRepository;
    
    public void initEnvironment() throws SQLException {
        userRepository.createTableIfNotExists();
    }
    
    
    public void processSuccess() throws SQLException {
        log.info("-------------- Process Success Begin ---------------");
        List<Long> userIds = insertData();
        printData();
        log.info("-------------- Process Success Finish --------------");
    }
    
    private List<Long> insertData() throws SQLException {
        log.info("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("test_mybatis_" + i);
            user.setPwd("pwd_mybatis_" + i);
            userRepository.insert(user);
            result.add((long) user.getUserId());
        }
        return result;
    }
    
    public void processFailure() throws SQLException {
        log.info("-------------- Process Failure Begin ---------------");
        insertData();
        log.info("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }
    
    
    public void printData() throws SQLException {
        log.info("---------------------------- Print User Data -----------------------");
        userRepository.selectAll().stream().forEach(user -> log.info("user:{}", user));
    }
}
