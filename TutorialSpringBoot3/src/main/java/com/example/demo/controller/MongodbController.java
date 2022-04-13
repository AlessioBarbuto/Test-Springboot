package com.example.demo.controller;

import com.example.demo.Service.CountryInformationService;
import com.example.demo.Service.PeopleInformationService;
import com.example.demo.model.CountryInformation;
import com.example.demo.model.PeopleInformation;
import com.example.demo.repository.CountryInformationRepository;
import com.example.demo.repository.PeopleInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class MongodbController {

    @Autowired
    CountryInformationService countryInformationService;
    @Autowired
    PeopleInformationService peopleInformationService;

    @Autowired
    PeopleInformationRepository peopleInformationRepository;
    @Autowired
    CountryInformationRepository countryInformationRepository;

    /**
     * Read the input csv file and write on mongodb the collection
     * @return
     * @throws IOException
     */
    @Transactional
    @GetMapping("/writePeopleOnDB")
    public List<PeopleInformation> writePeopleOnDB() throws IOException {

        List<PeopleInformation> peopleInformationList = null;

        try {
            List<String> linesOfCSV = peopleInformationService.readCsv("people-informations-data.csv");
            peopleInformationList = peopleInformationService.splitLinesAndMap(linesOfCSV);
            peopleInformationRepository.saveAll(peopleInformationList);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return peopleInformationList;

    }


    /**
     * Read the input csv file and write on mongodb the collection
     * @return
     * @throws IOException
     */
    @GetMapping("/writeCountryOnDB")
    public List<CountryInformation> writeCountryOnDB() throws IOException {

        List<CountryInformation> countryInformationList = null;

        try {
            List<String> linesOfCSV = countryInformationService.readCsv("country-trade-informations.csv");
            countryInformationList = countryInformationService.splitLinesAndMap(linesOfCSV);
            countryInformationRepository.saveAll(countryInformationList);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return countryInformationList;

    }


    /**
     * Ottengo i dati dal db che hanno parametro "amount" maggiore di 50
     * @return
     */
    @GetMapping("/retrievePeopleByAge")
    public ResponseEntity<List<PeopleInformation>> retrievePeopleByAge(){
        return new ResponseEntity<>(peopleInformationRepository.updateAgeForEthnic(5,1), HttpStatus.OK);

    }

    @GetMapping("/findPeopleByAreaAndCount")
    public ResponseEntity<List<PeopleInformation>> findPeopleByAreaAndCount(){
        String area = "01";
        long count = 795;

        return new ResponseEntity<>(peopleInformationService.getAllPeopleByAreaAndCount(area, count), HttpStatus.OK);
    }

}

