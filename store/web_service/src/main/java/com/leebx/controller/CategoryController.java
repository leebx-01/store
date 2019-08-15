package com.leebx.controller;

import com.github.pagehelper.PageInfo;
import com.leebx.pojo.Sku_web;
import com.leebx.pojo.Spu_web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class CategoryController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getList")
    public String getList(ModelMap modelMap){
        String url = "http://product-service/category/get";
        List list = restTemplate.getForObject(url, List.class);
        modelMap.put("list",list);
        return "index";
    }
    @RequestMapping("/getId")
    public String getId(String id,ModelMap modelMap,String page,String size){
        String url = "http://product-service/porductList/getId?id="+id+"&page="+page+"&size="+size;
        PageInfo pageInfo = restTemplate.getForObject(url, PageInfo.class);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("id",id);
        return "search";
    }
    @RequestMapping("/item")
    public String getItem(Long skuId,ModelMap modelMap){
        String url = "http://product-service/porductList/item?id="+skuId;
        Sku_web sku_web = restTemplate.getForObject(url, Sku_web.class);
        modelMap.put("sku",sku_web);
        return "item";
    }
}
