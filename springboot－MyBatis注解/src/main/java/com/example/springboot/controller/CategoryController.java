package com.example.springboot.controller;


import com.example.springboot.mapper.CategoryMapper;
import com.example.springboot.pojo.Category;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-9下午5:17
 **/

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public List<Category> listCategoryByMybatis() {
        return categoryMapper.findCategoryAll();
    }

    @RequestMapping("/getCategoryById/{id}")
    public Category getCategory(@PathVariable(value = "id",required = true)Integer id) {
        return categoryMapper.findCategoryById(id);
    }

    @RequestMapping("/addCategoryByName/{name}")
    public void createCategoryByMybatis(@PathVariable(value = "name") String name) {
        categoryMapper.saveByName(name);
    }


    @RequestMapping("/updateById/{id}/{name}")
    public void updateCategoryById(@PathVariable(value = "id")Integer id,
                                   @PathVariable(value = "name")String name) {
        categoryMapper.update(id,name);
    }

    @RequestMapping("/deleteCategoryById/{id}")
    public void deleteCategoryById(@PathVariable(value = "id")Integer id) {
        categoryMapper.deleteById(id);
    }

}
