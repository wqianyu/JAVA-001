package io.kaitoshy;


import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kaito
 * @createDate 2020/11/17 17:23
 */

public class SpringBeanDemo {

    public static void main(String[] args) {
        // 通过xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student123 = (Student) context.getBean("student456");
        System.out.println(student123.toString());


        // 通过 Configuration + bean
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerBean(TransportUtil.class);
        ctx.refresh();
        Bus bus = (Bus)ctx.getBean("bus");
        ctx.close();
        System.out.println(bus);

        // 通过 component
        School school = context.getBean(School.class);
        System.out.println(school.toString());

        // 通过 component + condition
        try {
            Breakfast breakfast = context.getBean(Breakfast.class);
            System.out.println(breakfast.toString());
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println(">==========该类没被加载");
            e.printStackTrace();
        }
    }
}
