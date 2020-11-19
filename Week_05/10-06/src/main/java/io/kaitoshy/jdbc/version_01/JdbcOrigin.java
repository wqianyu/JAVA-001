package io.kaitoshy.jdbc.version_01;

import java.sql.*;

/**
 * @author kaito
 * @createDate 2020/11/18 23:07
 */
public class JdbcOrigin {
    public static final String URL = "jdbc:h2:mem:test-db";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("org.h2.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL);

        Statement stmt = conn.createStatement();
        createTable(stmt);
        //3.操作数据库，实现增删改查
        stmt.executeUpdate("insert into t_user values(1, 2222, 22)");
        stmt.executeUpdate("insert into t_user values(2, 3333, 44)");
        System.out.println(">=======新增");
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM t_user");
        //如果有数据，rs.next()返回true
        while (rs.next()) {
            System.out.println(rs.getString("user_name") + " 年龄：" + rs.getInt("age"));
        }
        stmt.executeUpdate("update t_user set user_name='sss' where id=2");
        System.out.println(">=======修改");
        rs = stmt.executeQuery("SELECT user_name, age FROM t_user where id=2 limit 1");
        while (rs.next()) {
            System.out.println(rs.getString("user_name") + " 年龄：" + rs.getInt("age"));
        }

        stmt.executeUpdate("delete t_user where id=2");
        System.out.println(">=======删除");
        rs = stmt.executeQuery("SELECT user_name, age FROM t_user");
        while (rs.next()) {
            System.out.println(rs.getString("user_name") + " 年龄：" + rs.getInt("age"));
        }

        dropTable(stmt);
        stmt.close();
        conn.close();
    }

    private static boolean createTable(Statement stmt)  {
        try {
            String sql = "CREATE TABLE t_user (" +
                    "id int primary key not null," +
                    "user_name VARCHAR(20) NOT NULL," +
                    "age VARCHAR(32) NOT NULL" +
                    ")";
            stmt.execute(sql);
        } catch (SQLException sqle) {
            System.out.println(">====建表失败！！");
            sqle.printStackTrace();
        }

        return false;
    }

    private static void dropTable(Statement stmt) {
        try {
            stmt.execute("drop TABLE if exists t_user;");
        } catch (SQLException sqle) {
            System.out.println(">====删表失败！！");
            sqle.printStackTrace();
        }
    }
}
