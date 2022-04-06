package com.example.demo.controller;

import com.example.demo.Service.CountryInformationService;
import com.example.demo.Service.PeopleInformationService;
import com.example.demo.model.CountryInformation;
import com.example.demo.model.PeopleInformation;
import com.example.demo.repository.CountryInformationRepository;
import com.example.demo.repository.PeopleInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/writePersonOnDB")
    public List<PeopleInformation> writePersonOnDB() throws IOException {

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

}

