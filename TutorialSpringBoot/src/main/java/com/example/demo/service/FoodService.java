package com.example.demo.service;

import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.FoodNutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodService {

    @Autowired
    FoodNutrientRepository foodNutrientRepository;

    public List<FoodNutrient> extractByAmountQuery(){
        foodNutrientRepository.find
    }


}
