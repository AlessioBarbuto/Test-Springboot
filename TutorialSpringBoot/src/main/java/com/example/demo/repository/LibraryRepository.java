package com.example.demo.repository;

import com.example.demo.entity.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
