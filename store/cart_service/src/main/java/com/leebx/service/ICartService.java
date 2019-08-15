package com.leebx.service;

import com.leebx.pojo.Sku;

import java.util.List;

public interface ICartService {
    public Sku findSkuById(Long id);

    void addItem(String userId, Sku sku);

    List<Sku> getCart(String userId);

    void del(String userId, String skuId);

    void update(String userId,Integer num,String skuId);
}
