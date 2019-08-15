package com.leebx.controller;

import com.google.gson.Gson;
import com.leebx.pojo.Order_web;
import com.leebx.pojo.Sku_web;
import com.leebx.util.PayDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/order-web")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;
    @Autowired
    private PayDemo payDemo;
    @RequestMapping("/showOrder")
    public String showOrder(String skuId, String userId, ModelMap modelMap){
        String url = "http://order-service/order/findSkuById?skuId="+skuId+"&userId="+userId;
        Sku_web[] sku = restTemplate.getForObject(url, Sku_web[].class);
        Long sum = 0L;
        for (int i = 0; i < sku.length; i++) {
            sum+=sku[i].getTotal();
        }
        modelMap.put("list",sku);
        modelMap.put("sum",sum);
        return "getOrderInfo";
    }
    @RequestMapping("/submitOrder")
    public String submitOrder(String[] skuId, Order_web order,ModelMap modelMap){
        String json = gson.toJson(order);
        String json1 = gson.toJson(skuId);
        String url = "http://order-service/order/addOrder?skuId="+json1+"&order="+json;
        Order_web order_web = restTemplate.getForObject(url, Order_web.class, json, json1);
        modelMap.put("order",order_web);
        modelMap.put("code_url",payDemo.testPay(order_web));
        return "pay";
    }
    @RequestMapping("/paySuccess")
    public void paySuccess(String oid, HttpServletResponse response){
        try {
            PrintWriter writer = response.getWriter();
            String s = payDemo.queryPay(oid);
            writer.println(s);
        }catch (Exception e){

        }
    }
}
