package com.example.demo.controller;

import com.example.demo.dto.BuyBookDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Buyer;
import com.example.demo.entity.Ordine;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.OrdineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RestController
public class OrdersController {

    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    private Environment env;

    ReentrantLock lock = new ReentrantLock();

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody BuyBookDto buyBookDto){

        Book book = bookRepository.findByTitle(buyBookDto.getBookTitle());
        //lock.lock();

        try {
            int startqty = book.getQuantity();
            if (startqty >= buyBookDto.getQuantity()) {

                Buyer user = buyerRepository.findByUsername(buyBookDto.getUsername());
                Ordine ordine = new Ordine(user, book);
                ordineRepository.save(ordine);

                int updatedQty = startqty - buyBookDto.getQuantity();
                bookRepository.update(updatedQty,book.getTitle());
                log.info("quantità nel magazzino aggiornata!");

                return new ResponseEntity<String>("ordine inserito: " + ordine.toString(), HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*finally {
            lock.unlock();
        }*/
        log.info("Disponibilità terminata!");
        return new ResponseEntity<String>("Disponibilità Terminata!" , HttpStatus.OK);
    }

    @GetMapping("/getDeveloper")
    public String getDeveloper(){
        return env.getProperty("developer");

    }


}
