package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    //@Transactional
    //@Query("SELECT b FROM Book b WHERE b.author_id=:authorName")
    //List<Book> findByAuthorName(String authorName);
}
