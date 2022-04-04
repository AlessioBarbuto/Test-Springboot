package com.example.demo.repository;

import com.example.demo.entity.Cereal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CerealRepository extends JpaRepository<Cereal, Long> {
}
