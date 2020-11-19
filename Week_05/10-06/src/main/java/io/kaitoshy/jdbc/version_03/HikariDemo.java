package io.kaitoshy.jdbc.version_03;

import io.kaitoshy.jdbc.version_02.entity.User;
import io.kaitoshy.jdbc.version_03.hikari.HikariDbUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito
 * @createDate 2020/11/19 09:41
 */
public class HikariDemo {
    public static void main(String[] args) {
        HikariDbUtil util = new HikariDbUtil();
        try {
            util.initEnv();
            util.insert(User.builder().id(666L).userName("张三").age(30).build());
            List<User> users = util.list();
            users.forEach(System.out::println);

            System.out.println(">=== 批处理");
            Long beginTime = System.currentTimeMillis();
            User user1 = User.builder().id(667L).userName("张四").age(30).build();
            User user2 = User.builder().id(668L).userName("张五").age(29).build();
            List<User> userList = new ArrayList<>();
            userList.add(user1);
            userList.add(user2);
            util.batchInsert(userList);
            List<User> afterInsertUsers = util.list();
            afterInsertUsers.forEach(System.out::println);
            System.out.printf(">=====批处理时间:" + (System.currentTimeMillis() - beginTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                util.destroyEnv();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
