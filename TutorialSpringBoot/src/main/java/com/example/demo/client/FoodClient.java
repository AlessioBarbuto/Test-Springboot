package com.example.demo.client;

import com.example.demo.entity.FoodNutrient;
import feign.RequestLine;

import java.util.List;

public interface FoodClient {

    @RequestLine("GET")
    List<FoodNutrient> findAllFoods();
}
