package com.leebx.controller;

import com.leebx.pojo.Category;
import com.leebx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/get")
    public List<Category> getCategory(){
        List<Category> list = categoryService.getCateGory();
        return list;
    }
}