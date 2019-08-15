package com.leebx.mapper;

import com.leebx.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper {
    @Select("SELECT * FROM tb_sku WHERE id=#{id}")
    public Sku findSkuById(Long id);
}
