package com.example.demo.service;

import com.example.demo.repository.FoodNutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FoodService {

    @Autowired
    FoodNutrientRepository foodNutrientRepository;


}
