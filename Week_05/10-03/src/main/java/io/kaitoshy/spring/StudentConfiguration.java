package io.kaitoshy.spring;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito
 * @createDate 2020/11/18 19:54
 */

@Configuration
@ConditionalOnClass(Student.class)
public class StudentConfiguration {
    private Student student;


    @Bean
    @ConditionalOnMissingBean(Student.class)
    @ConditionalOnProperty(name = "student.enabled", havingValue = "true", matchIfMissing = true)
    public Student student() {
        student = new Student(800, "kaitoShy");
        return student;
    }

    @Bean
    @ConditionalOnBean(Student.class)
    public Klass klass() {
        Klass klass = new Klass();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(new Student(802, "ks22"));
        klass.setStudents(studentList);
        return klass;
    }

    @Bean
    @ConditionalOnBean(Student.class)
    public School school() {
        School school = new School();
        return school;
    }

}
