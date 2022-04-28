package com.example.demo.repository;

import com.example.demo.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    @Transactional
    @Query("SELECT u FROM Buyer u WHERE u.username = :username")
    Buyer findByUsername(String username);

}
