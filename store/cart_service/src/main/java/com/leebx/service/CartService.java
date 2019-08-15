package com.leebx.service;

import com.google.gson.Gson;
import com.leebx.mapper.CartMapper;
import com.leebx.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cartService")
public class CartService implements ICartService{
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private Gson gson;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public Sku findSkuById(Long id) {
        return cartMapper.findSkuById(id);
    }

    @Override
    public void addItem(String userId, Sku sku) {
        String skuId=sku.getId()+"";
        Integer num=sku.getNum();
        BoundHashOperations options = redisTemplate.boundHashOps(userId);
        if(options.hasKey(skuId)){
            //根据skuId在redis中查询sku是否存在
            sku=gson.fromJson(options.get(skuId).toString(),Sku.class);
            sku.setNum(sku.getNum()+num);
        }
        options.put(skuId,gson.toJson(sku));
    }
    //显示购物车信息
    @Override
    public List<Sku> getCart(String userId) {
        BoundHashOperations operations = redisTemplate.boundHashOps(userId);
        List<String> values = operations.values();
        List<Sku> list = new ArrayList<Sku>();
        for(String s : values){
            Sku sku = gson.fromJson(s, Sku.class);
            Long total =sku.getPrice() * sku.getNum().longValue();
            sku.setTotal(total);
            list.add(sku);
        }
        return list;
    }

    @Override
    public void del(String userId, String skuId) {
        redisTemplate.opsForHash().delete(userId,skuId);
    }

    @Override
    public void update(String userId, Integer num, String skuId) {
        BoundHashOperations operations = redisTemplate.boundHashOps(userId);
        Sku sku = gson.fromJson(operations.get(skuId).toString(), Sku.class);
        sku.setNum(num);
        operations.put(skuId,gson.toJson(sku));
    }
}
