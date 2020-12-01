package com.example.demo;

import com.example.demo.dao.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {
    private final static int MAX_ROW = 10000;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Override
    public void run(final String... args) {
        // 10 w 条批量执行时间：24062ms
        insertOrdersWithBatchAdd();
        truncateOrderTable();
        
        // 
        insertOrdersWithAutoCommit();
        truncateOrderTable();
    }
    
    private void insertOrdersWithBatchAdd() {
       
        String sql = "insert ss_order(`price` ,`amount` ,`total_price` ,`state` ,`item_id` ,`user_id` ,`create_time`,`update_time`)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        ParameterizedPreparedStatementSetter<Order> setter = (preparedStatement, order) -> {
            preparedStatement.setBigDecimal(1, order.getPrice());
            preparedStatement.setInt(2, order.getAmount());
            preparedStatement.setBigDecimal(3, order.getTotalPrice());
            preparedStatement.setInt(4, order.getState());
            preparedStatement.setLong(5, order.getItemId());
            preparedStatement.setLong(6, order.getUserId());
            preparedStatement.setLong(7, order.getCreateTime());
            preparedStatement.setLong(8, order.getUpdateTime());
        };
        //for (int i = 0; i < 1000000; i++) {
        List<Order> orderList = new LinkedList<>();
        for (int i = 0; i < MAX_ROW; i++) {
            orderList.add(
                    Order.builder()
                            .price(new BigDecimal("3.00"))
                            .amount(20)
                            .totalPrice(new BigDecimal("60.00"))
                            .state(1)
                            .itemId(100100L)
                            .userId(1000100L)
                            .createTime(1606837999L)
                            .updateTime(1606837999L)
                    .build());
        }
        long startTime = System.currentTimeMillis();
        jdbcTemplate.batchUpdate(sql, orderList, 10000, setter);
        //}
        log.info(">=====批量执行{}条数据时间：{}ms", MAX_ROW, System.currentTimeMillis() - startTime);
    }
    
    
    
    private void insertOrdersWithAutoCommit() {
        long startTime = System.currentTimeMillis();
        String sql = "insert ss_order(`price` ,`amount` ,`total_price` ,`state` ,`item_id` ,`user_id` ,`create_time`,`update_time`)"
                + " values(3.00, 20, 60.00, 1, 100100, 1000100, 1606837999, 1606837999)";
        for (int i = 0; i < 1000000; i++) {
            jdbcTemplate.execute(sql);
        }
        log.info(">=====自动提交{}条数据执行时间：{}ms", MAX_ROW, System.currentTimeMillis() - startTime);
    }
    
    private void truncateOrderTable() {
        jdbcTemplate.execute("truncate ss_order");
        log.info(">====数据库清理完毕");
    }
    
}
