package com.example.demo.controller;

import com.example.demo.client.CerealClient;
import com.example.demo.client.FoodClient;
import com.example.demo.entity.Cereal;
import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.CerealRepository;
import com.example.demo.repository.FoodNutrientRepository;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {

    //Repo foodnutrient
    private final FoodNutrientRepository foodNutrientRepository;
    FoodController(FoodNutrientRepository repository) {foodNutrientRepository = repository;}

    //repo cereal
    @Autowired
    private CerealRepository cerealRepository;

    //Feign FoodClient
    FoodClient foodClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(FoodClient.class))
            .logLevel(Logger.Level.FULL)
            .target(FoodClient.class, "http://localhost:8080/foodnutrientAPI");

    //Feign CerealClient
    CerealClient cerealClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(CerealClient.class))
            .logLevel(Logger.Level.FULL)
            .target(CerealClient.class, "http://localhost:8080/cerealsAPI");

    /**
     * Ottengo le API del microservizio B
     * @return
     */
    @GetMapping("/getFoodAPI")
    public ResponseEntity<List<FoodNutrient>> getFoodAPI() {

        List<FoodNutrient> foodNutrientList = null;
        try {
            foodNutrientList = new ArrayList<>(foodClient.findAllFoods());
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }


    /**
     * Scrivo sul db le FoodApi ricevute dal ms B
     * @return
     */
    @GetMapping("/writeFoodsOnDB")
    public ResponseEntity<List<FoodNutrient>> writeFoodsOnDB(){

        List<FoodNutrient> foodNutrientList = null;
        try {
            foodNutrientList = new ArrayList<>(foodClient.findAllFoods());
        }catch (Exception e){
            e.printStackTrace();
        }

        assert foodNutrientList != null;
        foodNutrientRepository.saveAll(foodNutrientList);

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }


    /**
     * Scrivo sul db le CerealsApi ricevute dal ms B
     * @return
     */
    @GetMapping("/writeCerealsOnDB")
    public ResponseEntity<List<Cereal>> writeCerealsOnDB(){

        List<Cereal> cerealList = new ArrayList<>();
        try{
            cerealList = cerealClient.findAllCereals();
            cerealRepository.saveAll(cerealList);
        } catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<>(cerealList, HttpStatus.OK);
    }


    /**
     * Ottengo i dati dal db che hanno parametro "amount" maggiore di 50
     * @return
     */
    @GetMapping("/getFoodFilteredByAmount")
    public ResponseEntity<List<FoodNutrient>> getFoodFilteredByAmount(){
        return new ResponseEntity<>(foodNutrientRepository.amountGreatThanQuery(50.0), HttpStatus.OK);
    }

}
