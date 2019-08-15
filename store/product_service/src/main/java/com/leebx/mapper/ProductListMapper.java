package com.leebx.mapper;

import com.leebx.pojo.Spu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductListMapper {
    @Select("SELECT * FROM tb_spu WHERE cid3=#{cid}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="sub_title",property="sub_title"),
            @Result(column="cid1",property="cid1"),
            @Result(column="cid2",property="cid2"),
            @Result(column="cid3",property="cid3"),
            @Result(column="brand_id",property="brand_id"),
            @Result(column="saleable",property="saleable"),
            @Result(column="valid",property="valid"),
            @Result(column="create_time",property="create_time"),
            @Result(column="last_update",property="last_update"),
            @Result(column="id",property="skuList",many=@Many(select="com.leebx.mapper.SkuMapper.findSku"))
    })
    public List<Spu> findSpu(Long cid);
}
