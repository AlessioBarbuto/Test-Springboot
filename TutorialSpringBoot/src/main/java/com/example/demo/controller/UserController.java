package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //collegamento interfaccia-controller
    private final UserRepository userRepository;
    UserController(UserRepository repository) {
        userRepository = repository;
    }


    //mappatura Get per recupero di tutti gli Users
    @GetMapping("/getUsers")
    @Operation(summary = "Get all Users in db")
    List<User> getUsers(){
        return userRepository.findAll();
    }

    //mappatura Get per cancellazione di un User
    @DeleteMapping("/deleteUser/{id}")
    @Operation(summary = "Delete a user by id")
    void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    //mappatura Get per inserire un nuovo User
    @PostMapping("/addUser")
    @Operation(summary = "add a new user")
    User crateUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //mappatura Get per aggiornare un User
    @PutMapping("/updateUser/{userId}")
    @Operation(summary = "update a user by id")
    User updateUser(@PathVariable Long userId, @RequestBody User updatedFields){
        User userToUpdate = userRepository.findById(userId).orElseThrow();
        userToUpdate.setName(updatedFields.getName());
        userToUpdate.setEmail(updatedFields.getEmail());
        return userRepository.save(userToUpdate);
    }


}
