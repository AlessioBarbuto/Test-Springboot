package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class InnerJoinController {

    @Autowired
    CompanyRepository companyRepository;

   /* @GetMapping("/innerJoin/{authorName}")
    ResponseEntity<List<Author>> executeInnerJoin(@PathParam("authorName") String authorName){
        return new ResponseEntity<>(companyRepository.innerJoin(authorName), HttpStatus.OK);
    }*/

}
