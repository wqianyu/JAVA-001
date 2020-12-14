drop table if exists `ss_order_0`;
CREATE TABLE `ss_order_0` (
  `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `amount` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '件数',
  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '总价',
  `state` tinyint(3) NOT NULL DEFAULT '1' COMMENT '0 -> 未支付， 1 -> 已支付， 2-> 已发货， 3 -> 已收货',
  `item_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `create_time` bigint(20) unsigned NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) unsigned NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_user` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='订单表';