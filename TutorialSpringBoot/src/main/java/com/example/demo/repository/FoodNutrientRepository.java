package com.example.demo.repository;

import com.example.demo.entity.FoodNutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//interfaccia per interagire con il db
public interface FoodNutrientRepository extends JpaRepository <FoodNutrient, Long> {

    //metodo 1 Hibenate
    Optional<FoodNutrient> findById(Long id);

    Optional<FoodNutrient> findByAmount(Integer amount);

    //metodo 2 Hibernate x query + complesse
    @Query("SELECT a FROM FoodNutrient a WHERE 1=:nome")
    FoodNutrient metodoDue(@Param("nome") String nome);
}
