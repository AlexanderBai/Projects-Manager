package com.example.use_templates_with_springboot.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-29上午12:30
 **/
@Data
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String context;

    public Entry() {
    }

    public Entry(String title, String context) {
        this.title = title;
        this.context = context;
    }
}
