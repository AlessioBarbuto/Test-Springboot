package com.example.demo.controller;

import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.FoodNutrientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class FoodController {

    //collegamento interfaccia-controller
    private final FoodNutrientRepository foodNutrientRepository;
    FoodController(FoodNutrientRepository repository) {
        foodNutrientRepository = repository;
    }



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
            for (FoodNutrient foodNutrient:foodNutrients) {
                foodNutrientList.add(foodNutrient);
            }
        } catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }

    /**
     * Scrivo sul db le Api ricevute dal ms B
     * @return
     */
    @GetMapping("/writeAPIonDB")
    public ResponseEntity<List<FoodNutrient>> writeApiOnDB(){

        FoodNutrient[] foodNutrients = null;
        List<FoodNutrient> foodNutrientList = new ArrayList<>();
        String url = "http://localhost:8080/foodnutrientAPI";

        RestTemplate restTemplate = new RestTemplate();
        try{
            foodNutrients = restTemplate.getForEntity(url, FoodNutrient[].class).getBody();
            //salvo in una lista
            for (FoodNutrient foodNutrient:foodNutrients) {
                foodNutrientList.add(foodNutrient);
            }

            foodNutrientRepository.saveAll(foodNutrientList);

        } catch(Exception e){
            e.getMessage();
        }

        return new ResponseEntity<>(foodNutrientList, HttpStatus.OK);
    }


/*

    //mappatura Get per inserire un nuovo Food
    @PostMapping("/addFood")
    FoodNutrient createFood(@RequestBody FoodNutrient newFood){
        return foodNutrientRepository.save(newFood);
    }

    //mappatura Get per recupero di tutti i Food nel DB
    @GetMapping("/getFoods")
    List<FoodNutrient> getFoods(){
        return foodNutrientRepository.findAll();
    }*/

}
