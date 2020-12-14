package com.example.proxy;

import com.example.proxy.dao.Order;
import com.example.proxy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@MapperScan("com.example.proxy.mapper")
@Slf4j
public class ProxyApplication implements CommandLineRunner {
    @Resource
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info(">===============start demo========");

        boolean isInsertSuccess = orderService.createOrder();
        log.info(">=====是否成功创建100条数据：{}", isInsertSuccess);
        Long orderTotal = orderService.countOrder();
        log.info(">=======现有多少条：{}", orderTotal);

        log.info(">=======获取订单列表");
        List<Order> orderList = orderService.listOrder();
        orderList.forEach(order -> log.info("{}", order));
        log.info(">==========更新数据==================");
        Order updateOrder = orderService.saveTotalPriceOrder(orderList.get(0).getOrderId(), new BigDecimal("70000"));
        log.info(">=======更新后的数据：{}", updateOrder);

        log.info(">==========删除数据==================");
        Integer deleteCount = orderService.deleteOrder(orderList.get(0).getOrderId());
        log.info(">=======成功删除：{}", deleteCount);
        Long remainingTotal = orderService.countOrder();
        log.info(">=======剩余多少条：{}", remainingTotal);

        log.info("===============end demo========<");
    }
}
