package com.leebx.service;

import com.google.gson.Gson;
import com.leebx.mapper.OrderMapper;
import com.leebx.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("orderService")
public class OrderService implements IOrderService{
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private Gson gson;
    public List findSkuById(String[] skuId,String userId){
        BoundHashOperations operations = redisTemplate.boundHashOps(userId);
        List<Sku> list = new ArrayList<Sku>();
        for (int i = 0; i < skuId.length; i++) {
            Sku sku = gson.fromJson(operations.get(skuId[i]).toString(), Sku.class);
            Long total =sku.getPrice() * sku.getNum().longValue();
            sku.setTotal(total);
            list.add(sku);
        }
        return list;
    }

    @Override
    public Order addOrder(String[] skuId,Order order) {
        Long id = snowflakeIdWorker.nextId();//生成雪花id
        Long total = 0L;
        BoundHashOperations operations = redisTemplate.boundHashOps(order.getUserId());
        for (int i = 0; i < skuId.length; i++) {
            Sku sku = gson.fromJson(operations.get(skuId[i]).toString(), Sku.class);
            total +=sku.getPrice() * sku.getNum().longValue();
            orderMapper.addOrderDetail(new OrderDetail(0L,id,skuId[i],sku.getNum(),sku.getTitle(),sku.getOwn_spec(),sku.getPrice(),sku.getImages()));
        }
        orderMapper.addOrderStatus(new OrderStatus(id,1));
        order.setOrderId(id);
        order.setTotalPay(total);
        orderMapper.addOrder(order);
        return order;
    }
}
