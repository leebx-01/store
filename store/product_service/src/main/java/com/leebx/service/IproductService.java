package com.leebx.service;

import com.leebx.pojo.Sku;
import com.leebx.pojo.Spu;

import java.util.List;

public interface IproductService {
    public List<Spu> findSpu(Long cid,Integer page,Integer size);

}
