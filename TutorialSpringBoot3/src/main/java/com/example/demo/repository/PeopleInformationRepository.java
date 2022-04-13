package com.example.demo.repository;

import com.example.demo.model.PeopleInformation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeopleInformationRepository extends MongoRepository<PeopleInformation , String> {

    Integer countByAgeBetween(Integer MinAge, Integer maxAge);

    //@Query(value = "db.getCollection(“peopleInformation”).count( { “age”: “?”} );", nativeQuery = true)
    @Query("SELECT COUNT p FROM alessiotest.peopleInformation WHERE p.age = :age ")
    Integer countByAgeGreatThan(Integer age);

    @Modifying
    @Query("UPDATE alessiotest.peopleInformation p SET p.age = :ageToSet WHERE p.ethnic = ethnicValue ")
    List<PeopleInformation> updateAgeForEthnic(Integer ageToSet, Integer ethnicValue);

}

