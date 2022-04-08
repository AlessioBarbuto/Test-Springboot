package com.example.demo.controller;

import com.example.demo.model.CountryInformation;
import com.example.demo.repository.CountryInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryCrudController {


    @Autowired
    CountryInformationRepository countryInformationRepository;

    /** ---------- Metodi CRUD base per PeopleInformation --------- **/

    @GetMapping("/getAllCountry")
    ResponseEntity<List<CountryInformation>> getAllCountry(){
        return new ResponseEntity<>(countryInformationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getCountryById/{id}")
    ResponseEntity<Optional<CountryInformation>> getAllCountryById(@PathParam("id") Long id){
        return new ResponseEntity<Optional<CountryInformation>>(countryInformationRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountryById/{id}")
    void deleteById(@PathParam("id") Long id){
        countryInformationRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllCountries/{id}")
    void deleteAll(){
        countryInformationRepository.deleteAll();
    }

    @PutMapping("/updateCountry/{id}")
    ResponseEntity<CountryInformation> updateCountry(@PathParam("id") Long id, @RequestBody CountryInformation updatedParams) throws Exception {
        CountryInformation countryToUpdate = countryInformationRepository.findById(id).orElseThrow(Exception::new);
        countryToUpdate.setCountryCode(updatedParams.getCountryCode());
        countryToUpdate.setAccount(updatedParams.getAccount());
        countryToUpdate.setCode(updatedParams.getCode());
        countryToUpdate.setProductType(updatedParams.getProductType());
        countryToUpdate.setStatus(updatedParams.getStatus());
        countryToUpdate.setTimeRef(updatedParams.getTimeRef());
        countryToUpdate.setValue(updatedParams.getValue());
        return new ResponseEntity<>(countryInformationRepository.save(countryToUpdate), HttpStatus.OK);
    }

    @PostMapping("/createNewCountry")
    ResponseEntity<CountryInformation> createNewCountry(@RequestBody CountryInformation countryParams){
        CountryInformation countryToAdd = null;
        countryToAdd.setCountryCode(countryParams.getCountryCode());
        countryToAdd.setAccount(countryParams.getAccount());
        countryToAdd.setCode(countryParams.getCode());
        countryToAdd.setProductType(countryParams.getProductType());
        countryToAdd.setStatus(countryParams.getStatus());
        countryToAdd.setTimeRef(countryParams.getTimeRef());
        countryToAdd.setValue(countryParams.getValue());
        return new ResponseEntity<>(countryInformationRepository.save(countryToAdd), HttpStatus.OK);
    }

}
