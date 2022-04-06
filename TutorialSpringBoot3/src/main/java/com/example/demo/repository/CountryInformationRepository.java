package com.example.demo.repository;

import com.example.demo.model.CountryInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryInformationRepository extends MongoRepository<CountryInformation, Long> {
}
