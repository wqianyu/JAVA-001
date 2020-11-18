package io.kaitoshy.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School  {

    // Resource
    @Autowired(required = true) //primary
    Klass class1;
    
    @Resource(name = "student100")
    Student student100;
}
