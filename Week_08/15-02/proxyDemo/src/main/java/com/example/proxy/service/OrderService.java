package com.example.proxy.service;

import com.example.proxy.dao.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kaito
 * @createDate 2020/12/9 23:07
 */
public interface OrderService {
   boolean createOrder();

   List<Order> listOrder();

   Order saveTotalPriceOrder(Long id, BigDecimal bigDecimal);

   Integer deleteOrder(Long id);

   Long countOrder();
}
