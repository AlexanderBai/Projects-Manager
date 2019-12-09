package com.example.springboot.controller;


import com.example.springboot.dao.CategoryDao;
import com.example.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-9下午5:17
 **/

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/listCategory")
    public List<Category> listCategory() {
        return (List<Category>) categoryDao.findAll();
    }

    //普通端接口方法
    @RequestMapping("/getCategory")
    public Optional<Category> getCategoryById(@RequestParam(value ="id",defaultValue = "１")int id) {
        return categoryDao.findById(id);
    }

    @RequestMapping("/getCategory/{id}")
    public Optional<Category> getCategoryById(@PathVariable("id")Integer id) {
        return categoryDao.findById(id);
    }

    //普通方法
    @RequestMapping("/addCategory")
    public Category createCategory(@RequestParam(value = "name",defaultValue = "默认")String name) {
        Category category = new Category();
        category.setName(name);
        return categoryDao.save(category);
    }

    @RequestMapping("/addCategory/{name}")
    public Category addCategory(@PathVariable(value = "name")String name) {
        Category category = new Category();
        category.setName(name);
        return categoryDao.save(category);
    }

    @RequestMapping("/delete/{id}")
    public Optional<Category> deleteCategoryById(@PathVariable(value = "id")int id) {
        categoryDao.deleteById(id);
        return categoryDao.findById(id);
    }

    @RequestMapping("/update/{id}/{name}")
    public Category updateCategory(@PathVariable(value = "id")int id,@PathVariable(value = "name") String name) {
        Category category;
        System.out.println(getCategoryById(id));
        if (getCategoryById(id)!=null) {
            Optional<Category> categoryById = getCategoryById(id);
            category = categoryById.get();
            category.setName(name);
            return categoryDao.save(category);
        }
        return null;
    }
}
