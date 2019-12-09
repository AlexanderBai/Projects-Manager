package com.example.springboot.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-9下午5:09
 **/

@Data
@Entity
@Table(name = "category_")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

}
