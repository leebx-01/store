package com.leebx.service;

import com.leebx.mapper.CategoryMapper;
import com.leebx.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCateGory(){
        List<Category> list1 = categoryMapper.getCateGory((long) 0);
        for(Category c:list1){
            Long cId = c.getId();
            List<Category> list2 = categoryMapper.getCateGory(cId);
            c.setSubList(list2);
            for(Category c2: list2){
                Long cId2 = c2.getId();
                List<Category> list3 = categoryMapper.getCateGory(cId2);
                c2.setSubList(list3);
            }
        }
        return list1;
    }

}