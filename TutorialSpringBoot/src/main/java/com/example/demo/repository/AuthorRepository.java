package com.example.demo.repository;

import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Transactional
    @Query("SELECT a FROM Author a WHERE a.name=:name")
    List<Author> findByName(String name);

}
