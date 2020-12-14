package com.example.proxy.mapper;

import com.example.proxy.dao.Order;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kaito
 * @createDate 2020/12/9 22:39
 */
public interface OrderMapper {
    Integer createOrder(Order order);

    List<Order> listOrder();

    Integer saveOrderPriceById(@Param("price")BigDecimal price, @Param("id")Long orderId);

    Integer deleteOrder(@Param("id") Long id);

    Long getCount();

    Order getOrder(@Param("id") Long id);
}
