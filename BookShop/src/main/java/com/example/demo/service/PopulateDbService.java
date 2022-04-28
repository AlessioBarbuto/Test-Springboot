package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Buyer;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BuyerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulateDbService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BuyerRepository buyerRepository;

    Faker faker = new Faker();

    public void populateDB(){

        int i = 0;

        do{
            Book book = new Book(faker.book().title(), faker.book().author(), 10, 2);
            bookRepository.save(book);
            Buyer buyer = new Buyer(faker.name().fullName());
            buyerRepository.save(buyer);

            i++;
        }while(i < 20);

    }
}
