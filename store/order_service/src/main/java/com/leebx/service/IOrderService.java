package com.leebx.service;

import com.leebx.pojo.Order;

import java.util.List;

public interface IOrderService {
    public List findSkuById(String[] skuId, String userId);
    public Order addOrder(String[] skuId,Order order);
}
