package com.kaitoshy.demo;

import com.kaitoshy.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@MapperScan(basePackages = "com.kaitoshy.demo.repository")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    
    public static void main(final String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Override
    public void run(final String... args) throws Exception { 
        userService.initEnvironment();
        userService.processSuccess();
    }
}
