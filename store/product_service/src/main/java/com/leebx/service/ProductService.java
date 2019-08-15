package com.leebx.service;

import com.github.pagehelper.PageHelper;
import com.leebx.mapper.ProductListMapper;
import com.leebx.mapper.SkuMapper;
import com.leebx.pojo.Sku;
import com.leebx.pojo.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements IproductService {
    @Autowired
    private ProductListMapper productListMapper;
    @Override
    public List<Spu> findSpu(Long cid,Integer page,Integer size) {
        PageHelper.startPage(page, size);
        List<Spu> spuList = productListMapper.findSpu(cid);
        return spuList;
    }


}
