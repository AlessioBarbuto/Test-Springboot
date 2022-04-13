package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopolamentoService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CompanyRepository companyRepository;


    Faker faker = new Faker();
    public void populateDB(){

        //non usare do-while, usare costrutti di Java8

        int i = 0;

        do{
           // Author authore = new Author();
           // authore.setName("tizio");

            Address address = new Address();
            address.setLocation((faker.address().streetAddress()));
            addressRepository.save(address);

            Library library = new Library();
            library.setName(faker.company().name());
            library.setAddress(address);
            libraryRepository.save(library);

            int j = 0;
            do{
                List<Book> bookList = new ArrayList<>();

                Book book = new Book();
                book.setTitle(faker.book().title());
                book.setLibrary(library);
                bookRepository.save(book);
                bookList.add(book);

                Book book2 = new Book();
                book2.setTitle(faker.book().title());
                book2.setLibrary(library);
                bookRepository.save(book2);
                bookList.add(book2);

                Author author = new Author();
                author.setName(faker.name().firstName());
                author.setBooks(bookList);
                authorRepository.save(author);

                Company company = new Company();
                company.setName(faker.company().name());
                company.setAuthor(author);
                companyRepository.save(company);

                j++;

            }while(j<3);

            i++;
        }
        while (i<10000);

    }

}
