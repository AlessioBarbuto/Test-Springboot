package com.example.demo.repository;

import com.example.demo.entity.FoodNutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//interfaccia per interagire con il db
public interface FoodNutrientRepository extends JpaRepository <FoodNutrient, Long> {

    //template metodo 1 Hibenate
    Optional<FoodNutrient> findByAmount(Integer amount);

    //template metodo 2 Hibernate x query + complesse
    @Query("SELECT a FROM FoodNutrient a WHERE 1=:nome")
    FoodNutrient metodoDue(@Param("nome") String nome);

    @Query("SELECT a FROM FoodNutrient a WHERE a.amount >:inputAmount")
    List<FoodNutrient> amountGreatThanQuery(@Param("inputAmount") Double amount);

    //TODO: inventare 3 relazioni (1 a 1, 1 a molti e molti a molti) e creo 3 entity con questo tipo di relazioni
    // poi faccio query. INDICI composti: cosa sono, come si definiscono, perchè ecc. svantaggi degli indici?
    // poi tipi di join, inner, full outer, right e left... AT: uni e bi direzionali
}
