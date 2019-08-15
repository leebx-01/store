package com.leebx.mapper;

import com.leebx.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CategoryMapper{
    @Select("SELECT * FROM tb_category WHERE parent_id = #{parent_id}")
    public List<Category> getCateGory(Long parent_id);
}
