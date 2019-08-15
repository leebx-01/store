package com.leebx.controller;

import com.google.gson.Gson;
import com.leebx.pojo.Order;
import com.leebx.pojo.Sku;
import com.leebx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private Gson gson;

    @RequestMapping("/findSkuById")
    public List findSkuById(String skuId, String userId){
        String[] split = skuId.split(",");
        List<Sku> list = orderService.findSkuById(split, userId);
        return list;
    }
    @RequestMapping("/addOrder")
    public Order addOrder(String skuId,String order){
        String[] strings = gson.fromJson(skuId, String[].class);
        Order order1 = gson.fromJson(order, Order.class);
        Order orderInfo = orderService.addOrder(strings, order1);
        return orderInfo;
    }

}
