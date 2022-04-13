package com.example.demo.controller;

import com.example.demo.model.PeopleInformation;
import com.example.demo.repository.PeopleInformationRepository;
import org.bson.types.ObjectId;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class PeopleCrudController {

    @Autowired
    PeopleInformationRepository peopleInformationRepository;

    /** ---------- Metodi CRUD base per PeopleInformation --------- **/

    @GetMapping("/getAllPeople")
    ResponseEntity<List<PeopleInformation>> getAllPeople(){
        return new ResponseEntity<>(peopleInformationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getPeopleById/{id}")
    ResponseEntity<Optional<PeopleInformation>> getAllPeopleById(@PathParam("id") String id){
        return new ResponseEntity<Optional<PeopleInformation>>(peopleInformationRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deletePeopleById/{id}")
    void deleteById(@PathParam("id") String id){
        peopleInformationRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllPeople/{id}")
    void deleteAll(){
        peopleInformationRepository.deleteAll();
    }

    @PutMapping("/updatePeople/{id}")
    ResponseEntity<PeopleInformation> updatePeople(@PathParam("id") String id, @RequestBody PeopleInformation updatedParams) throws Exception {
        PeopleInformation peopleToUpdate = peopleInformationRepository.findById(id).orElseThrow(Exception::new);
        peopleToUpdate.setAge(updatedParams.getAge());
        peopleToUpdate.setArea(updatedParams.getArea());
        peopleToUpdate.setCount(updatedParams.getCount());
        peopleToUpdate.setEthnic(updatedParams.getEthnic());
        peopleToUpdate.setSex(updatedParams.getSex());
        peopleToUpdate.setYear(updatedParams.getYear());
        return new ResponseEntity<>(peopleInformationRepository.save(peopleToUpdate), HttpStatus.OK);
    }

    @PostMapping("/createNewPeople")
    ResponseEntity<PeopleInformation> createNewPeople(@RequestBody PeopleInformation peopleToAdd){
        PeopleInformation peopleInformation = null;
        peopleInformation.setAge(peopleToAdd.getAge());
        peopleInformation.setArea(peopleToAdd.getArea());
        peopleInformation.setCount(peopleToAdd.getCount());
        peopleInformation.setEthnic(peopleToAdd.getEthnic());
        peopleInformation.setSex(peopleToAdd.getSex());
        peopleInformation.setYear(peopleToAdd.getYear());
        return new ResponseEntity<>(peopleInformationRepository.save(peopleToAdd), HttpStatus.OK);
    }


}
