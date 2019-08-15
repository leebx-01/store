package com.leebx.controller;

import com.github.pagehelper.PageInfo;
import com.leebx.pojo.Sku;
import com.leebx.pojo.Spu;
import com.leebx.service.ProductService;
import com.leebx.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/porductList")
public class ProductListController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SkuService skuService;
    @RequestMapping("/getId")
    public PageInfo getId(String id,String page,String size){
        Long cid = Long.parseLong(id);
        Integer pages = Integer.parseInt(page);
        Integer sizes = Integer.parseInt(size);
        List<Spu> spuList = productService.findSpu(cid,pages,sizes);
        for(Spu s : spuList){
            s.setSkuList(skuService.findSku(s.getId()));
        }
        PageInfo pageInfo = new PageInfo(spuList);
        return pageInfo;
    }
    @RequestMapping("/item")
    public Sku item(Long id){
        Sku sku = skuService.findSkuById(id);
        return sku;
    }
}
