package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopolamentoService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;

    Faker faker = new Faker();
    public void populateDB(){

        //non usare do-while, usare costrutti di Java8

        int i = 0;

        do{
            Address address = Address.builder()
                    .location(faker.address().streetAddress())
                    .build();
            addressRepository.save(address);

            Library library = Library.builder()
                    .name(faker.company().name())
                    .address(address)
                    .build();
            libraryRepository.save(library);

            int j = 0;
            do{
                Book book = Book.builder()
                        .title(faker.book().title())
                        .library(library)
                        .build();
                bookRepository.save(book);

                j++;
            }while(j<5);


            i++;
        }
        while (i<10000);

    }
}
