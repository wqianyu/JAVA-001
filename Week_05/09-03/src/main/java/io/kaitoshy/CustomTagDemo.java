package io.kaitoshy;

import io.kaitoshy.demo.Klass;
import io.kaitoshy.demo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaito
 * @createDate 2020/11/18 14:30
 */
public class CustomTagDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
        Student student = (Student)ctx.getBean("student005");
        System.out.println(student);

//        Klass class1 = ctx.getBean(Klass.class);
//        System.out.println(class1);
//        class1.getStudents();
    }
}
