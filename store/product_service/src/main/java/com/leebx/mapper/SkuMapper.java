package com.leebx.mapper;

import com.leebx.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkuMapper {
    @Select("SELECT * FROM tb_sku WHERE spu_id=#{id}")
    public List<Sku> findSku(Long id);
    @Select("SELECT * FROM tb_sku WHERE id=#{id}")
    public Sku findSkuById(Long id);
}
