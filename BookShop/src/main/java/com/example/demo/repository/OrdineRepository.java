package com.example.demo.repository;

import com.example.demo.entity.Ordine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends CrudRepository<Ordine, Long> {
}
