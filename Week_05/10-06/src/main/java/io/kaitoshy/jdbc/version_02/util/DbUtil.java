package io.kaitoshy.jdbc.version_02.util;

import io.kaitoshy.jdbc.version_02.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kaito
 * @createDate 2020/11/19 00:07
 */

public class DbUtil {
    public static final String URL = "jdbc:h2:mem:test-db";
    private Connection conn;
    private Statement stmt;

    /**
     * 初始化环境
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void initEnv() throws SQLException, ClassNotFoundException {
        //1.加载驱动程序
        Class.forName("org.h2.Driver");
        //2. 获得数据库连接
        conn = DriverManager.getConnection(URL);

        stmt = conn.createStatement();
        createTable(stmt);

    }

    /**
     * 销毁
     * @throws SQLException
     */
    public void destroyEnv() throws SQLException {
        dropTable(stmt);

        if (stmt != null) {
            stmt.close();
        }

        if (conn != null) {
            conn.close();
        }
    }

    public int insert(User users) {
        String sql = "INSERT INTO t_user(id, user_name, age) " +
                "VALUES(?,?,?)";
        //为占位符赋值
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, users.getId());
            preparedStatement.setString(2, users.getUserName());
            preparedStatement.setInt(3, users.getAge());
            //执行 SQL语句
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(">=====插入失败！");
            e.printStackTrace();
        }

        return 0;
    }

    public List<User> list() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT id, user_name, age FROM t_user");
            while (rs.next()) {
                users.add(User.builder()
                        .id(rs.getLong("id"))
                        .userName(rs.getString("user_name"))
                        .age(rs.getInt("age"))
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(">====查询列表失败");
            e.printStackTrace();
        }

        return users;
    }

    public void batchInsert(List<User> userList) throws SQLException {
        conn.setAutoCommit(false);
        PreparedStatement pstmt = conn.prepareStatement("insert into t_user values(?,?,?)");
        for (User user: userList) {
            pstmt.setLong(1, user.getId());
            pstmt.setString(2, user.getUserName());
            pstmt.setInt(3, user.getAge());
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        conn.commit();
        conn.setAutoCommit(true);
    }

    private boolean createTable(Statement stmt) {
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

    private void dropTable(Statement stmt) {
        try {
            stmt.execute("drop TABLE if exists t_user;");
        } catch (SQLException sqle) {
            System.out.println(">====删表失败！！");
            sqle.printStackTrace();
        }
    }
}
