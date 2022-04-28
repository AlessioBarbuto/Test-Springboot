package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findByTitle(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.quantity = :quantity WHERE title = :title")
    int update(int quantity, String title);
}
