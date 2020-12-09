package com.example.proxy.service.impl;

import com.example.proxy.dao.Order;
import com.example.proxy.mapper.OrderMapper;
import com.example.proxy.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kaito
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder() {
        int successFlag = 0;
        int insertTotal = 100;

        for (int i = 0;i < insertTotal; i++) {
            long time = System.currentTimeMillis();
            Order order = Order.builder().orderId((long) i)
                    .amount(i * 3).createTime(time)
                    .itemId((long) i * 2).price(BigDecimal.valueOf(13))
                    .state(1).totalPrice(BigDecimal.valueOf(300))
                    .userId((long) i % 13).updateTime(time).build();
            successFlag += orderMapper.createOrder(order);
        }

        return successFlag == insertTotal;
    }

    @Override
    public List<Order> listOrder() {
        return orderMapper.listOrder();
    }

    @Override
    public Order saveTotalPriceOrder(Long id, BigDecimal bigDecimal) {
        Integer updateCount = orderMapper.saveOrderPriceById(bigDecimal, id);
        if (updateCount > 0) {
            return orderMapper.getOrder(id);
        }

        return null;
    }

    @Override
    public Integer deleteOrder(Long id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public Long countOrder() {
        return orderMapper.getCount();
    }
}
