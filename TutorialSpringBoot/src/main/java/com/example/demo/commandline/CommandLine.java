package com.example.demo.commandline;

import com.example.demo.entity.FoodNutrient;
import com.example.demo.repository.FoodNutrientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    FoodNutrientRepository foodNutrientRepository;

    @Override
    public void run(String... args) throws Exception {

        FoodNutrient foodNutrient1 = FoodNutrient.builder()
                .nutrientId(2983L)
                .amount(10)
                .footNote("note")
                .build();

        FoodNutrient foodNutrient2 = FoodNutrient.builder()
                .nutrientId(2983L)
                .amount(10)
                .footNote("note")
                .build();

        List<FoodNutrient> foodNutrientList = new ArrayList<>();
        foodNutrientList.add(foodNutrient1);
        foodNutrientList.add(foodNutrient2);

        log.info("Salvo la lista");
        foodNutrientRepository.saveAll(foodNutrientList);
    }
}
