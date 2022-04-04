package com.example.demo.controller;

import com.example.demo.entity.Cereal;
import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.CerealRepository;
import com.example.demo.repository.FoodNutrientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FoodController {

    //Repo foodnutrient
    private FoodNutrientRepository foodNutrientRepository;
    FoodController(FoodNutrientRepository repository) {foodNutrientRepository = repository;}

    //repo cereal
    @Autowired
    private CerealRepository cerealRepository;
    //FoodController(CerealRepository repository2) {cerealRepository = repository2;}

    /**
     * Ottengo le API del microservizio B
     * @return
     */
    @GetMapping("/getFoodAPI")
    public ResponseEntity<List<FoodNutrient>> getFoodAPI(){
        FoodNutrient[] foodNutrients = null;
        List<FoodNutrient> foodNutrientList = new ArrayList<>();
        String url = "http://localhost:8080/foodnutrientAPI";

        RestTemplate restTemplate = new RestTemplate();
        try{
            foodNutrients = restTemplate.getForEntity(url, FoodNutrient[].class).getBody();
            //Salvo in una lista
            foodNutrientList.addAll(Arrays.asList(foodNutrients));
        } catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }

    /**
     * Scrivo sul db le FoodApi ricevute dal ms B
     * @return
     */
    @GetMapping("/writeFoodsOnDB")
    public ResponseEntity<List<FoodNutrient>> writeFoodsOnDB(){

        FoodNutrient[] foodNutrients = null;
        List<FoodNutrient> foodNutrientList = new ArrayList<>();
        String url = "http://localhost:8080/foodnutrientAPI";

        RestTemplate restTemplate = new RestTemplate();
        try{
            foodNutrients = restTemplate.getForEntity(url, FoodNutrient[].class).getBody();
            //salvo in una lista
            foodNutrientList.addAll(Arrays.asList(foodNutrients));

            foodNutrientRepository.saveAll(foodNutrientList);

        } catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }

/**
     * Scrivo sul db le CerealsApi ricevute dal ms B
     * @return
     */

    @GetMapping("/writeCerealsOnDB")
    public ResponseEntity<List<Cereal>> writeCerealsOnDB(){

        Cereal[] cereals = null;
        String url = "http://localhost:8080/cerealsAPI";
        List<Cereal> cerealList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        try{
            cereals = restTemplate.getForEntity(url, Cereal[].class).getBody();
            //salvo in una lista
            cerealList = (Arrays.asList(cereals));

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
