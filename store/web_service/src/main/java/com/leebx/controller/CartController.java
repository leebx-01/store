package com.leebx.controller;

import com.leebx.pojo.Sku_web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/add")
    public String add(Long userId, Long skuId, ModelMap modelMap){
        String url = "http://cart-service/cart/add?skuId="+skuId+"&userId="+userId;
        restTemplate.getForObject(url, Object.class);
        return "redirect:show?userId="+userId;
    }
    @RequestMapping("/show")
    public String show(Long userId, ModelMap modelMap,HttpSession session){
        String url = "http://cart-service/cart/show?userId="+userId;
        Sku_web[] list = restTemplate.getForObject(url, Sku_web[].class);
        Long sum = 0L;//总价
        for (int i = 0; i < list.length; i++) {
            sum+=list[i].getTotal();
        }
        modelMap.put("list",list);
        modelMap.put("sum",sum);
        if(session.getAttribute("user")==null){
            return "login";
        }
        return "cart";
    }
    @RequestMapping("/del")
    public String delCart(Long userId,Long skuId){
        String url = "http://cart-service/cart/del?userId="+userId+"&skuId="+skuId;
        restTemplate.getForObject(url,Object.class);
        return "redirect:show?userId="+userId;
    }
    @RequestMapping("/update")
    public String update(String userId,Integer num,String skuId){
        String url = "http://cart-service/cart/update?userId="+userId+"&num="+num+"&skuId="+skuId;
        restTemplate.getForObject(url,Object.class);
        return "redirect:show?userId="+userId;
    }
}
