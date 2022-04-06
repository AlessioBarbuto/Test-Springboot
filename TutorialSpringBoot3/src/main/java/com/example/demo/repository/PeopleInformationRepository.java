package com.example.demo.repository;

import com.example.demo.model.PeopleInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleInformationRepository extends MongoRepository<PeopleInformation , Long> {
}
