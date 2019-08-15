package com.leebx.controller;

import com.leebx.pojo.Sku;
import com.leebx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping("/add")
    public void add(Long skuId,String userId){
        Sku sku = cartService.findSkuById(skuId);
        sku.setNum(1);
        cartService.addItem(userId,sku);
    }
    @RequestMapping("/show")
    public List showCart(String userId){
        List<Sku> list = cartService.getCart(userId);
        return list;
    }
    @RequestMapping("/del")
    public void delCart(String userId,String skuId){
        cartService.del(userId,skuId);
    }
    @RequestMapping("/update")
    public void update(String userId,Integer num,String skuId){
        cartService.update(userId,num,skuId);
    }
}
