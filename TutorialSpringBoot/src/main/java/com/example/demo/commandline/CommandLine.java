package com.example.demo.commandline;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.PopolamentoService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PopolamentoService popolamentoService;

    @Override
    public void run(String... args) throws Exception {

        popolamentoService.populateDB();


/*
        Author autoreReplicante = Author.builder()
                .name("autore replicante")
                .build();

        List<Author> authorList = new ArrayList<>();
        authorList.add(hermanMelville);
        authorList.add(autoreReplicante);

        Book mobyDick = Book.builder()
                .title("Moby Dick")
                .authors(authorList)
                .build();

        Book robinsonCrusoe = Book.builder()
                .title("robinson crusoe")
                .build();

        List<Book> bookList = new ArrayList<>();
        bookList.add(mobyDick);
        bookList.add(robinsonCrusoe);

        Address torino = Address.builder()
                .location("Torino")
                .build();

        Library bibliotecaDiTorino = Library.builder()
                .name("biblioteca di Torino")
                .address(torino)
                .books(bookList)
                .build();

        addressRepository.save(torino);
        libraryRepository.save(bibliotecaDiTorino);
        authorRepository.saveAll(authorList);
        bookRepository.saveAll(bookList);

*/
    }

   /* @Autowired
    FoodNutrientRepository foodNutrientRepository;

    @Override
    public void run(String... args) throws Exception {

        FoodNutrient foodNutrient1 = FoodNutrient.builder()
                .nutrientId(2983L)
                .amount(60)
                .footNote("note")
                .build();

        FoodNutrient foodNutrient2 = FoodNutrient.builder()
                .nutrientId(2983L)
                .amount(70)
                .footNote("note")
                .build();

        List<FoodNutrient> foodNutrientList = new ArrayList<>();
        foodNutrientList.add(foodNutrient1);
        foodNutrientList.add(foodNutrient2);

        log.info("Salvo la lista");
        foodNutrientRepository.saveAll(foodNutrientList);

    }*/
}
