package com.leebx.service;

import com.leebx.mapper.SkuMapper;
import com.leebx.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skuService")
public class SkuService implements IskuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public List<Sku> findSku(Long id) {
        List<Sku> skuList = skuMapper.findSku(id);
        return skuList;
    }

    @Override
    public Sku findSkuById(Long id) {
        return skuMapper.findSkuById(id);
    }
}
