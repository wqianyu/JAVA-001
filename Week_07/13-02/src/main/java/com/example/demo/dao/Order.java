package com.example.demo.dao;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author kaito
 * @createDate 2020/12/1 23:36
 */
@Data
@Builder
public class Order {
    private Long orderId;
    private BigDecimal price;
    private Integer amount;
    private BigDecimal totalPrice;
    private Integer state;
    private Long itemId;
    private Long userId;
    private Long createTime;
    private Long updateTime;
}
