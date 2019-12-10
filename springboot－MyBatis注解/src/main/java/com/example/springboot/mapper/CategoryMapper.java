package com.example.springboot.mapper;

import com.example.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-10下午3:08
 **/
@Mapper
@Component
public interface CategoryMapper{

    @Select("select * from category_")
    public List<Category> findCategoryAll();

    @Select("select * from category_ where id=#{id}")
    public Category findCategoryById(Integer id);

    @Insert("insert into category_ (name) values (#{name})")
    public void saveByName(String name);

    @Update("update category_ set name=#{name} where id=#{id}")
    public void update(@Param("id")Integer id,@Param("name")String name);

    @Delete("delete from category_ where id=#{id}")
    public void deleteById(@Param("id") Integer id);


    @Delete("delete from category_ where id=#{id}")
    public void delete2(@org.apache.ibatis.annotations.Param("id") Integer id);
}
