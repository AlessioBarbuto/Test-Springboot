package com.example.demo.controller;

import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.FoodNutrientRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlessioTestController {

/*    //collegamento interfaccia-controller
    private final FoodNutrientRepository foodNutrientRepository;
    AlessioTestController(FoodNutrientRepository repository) {
        foodNutrientRepository = repository;
    }


    //mappatura Get per recupero di tutti i Food nel DB
    @GetMapping("/getFoods")
    @Operation(summary = "Get all Food in db")
    List<FoodNutrient> getFoods(){
        return foodNutrientRepository.findAll();
    }

    //mappatura Get per cancellazione di un Food
    @DeleteMapping("/deleteFood/{id}")
    @Operation(summary = "Delete a Food by id")
    void deleteFood(@PathVariable Long id){
        foodNutrientRepository.deleteById(id);
    }

    //mappatura Get per inserire un nuovo Food
    @PostMapping("/addFood")
    @Operation(summary = "add a new Food")
    FoodNutrient crateFood(@RequestBody FoodNutrient newFood){
        return foodNutrientRepository.save(newFood);
    }*/


}
