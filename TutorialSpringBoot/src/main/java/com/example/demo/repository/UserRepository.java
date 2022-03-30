package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//interfaccia per interagire con il db
public interface UserRepository extends JpaRepository <User, Long> {
}
