package com.example.use_templates_with_springboot.reposity;

import com.example.use_templates_with_springboot.domain.Entry;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-29上午12:40
 **/
public interface EntryRepository extends JpaRepository<Entry, Long> {

}
