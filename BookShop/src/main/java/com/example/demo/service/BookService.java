package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAttribute;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public String updateBookQtyTransaction(int n, String title){
        Book book = bookRepository.findByTitle(title);
        book.setQuantity(n);
        bookRepository.save(book);
        return "";
    }

}
