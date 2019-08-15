package com.leebx.service;

import com.leebx.pojo.Sku;

import java.util.List;

public interface IskuService {
    public List<Sku> findSku(Long id);
    public Sku findSkuById(Long id);
}
