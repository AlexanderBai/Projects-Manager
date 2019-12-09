package com.example.springboot.dao;

import com.example.springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-9下午5:15
 **/

public interface CategoryDao extends JpaRepository<Category,Integer> {

}
