package com.zse4p.movieapi.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.zse4p.movieapi.RegisterRequest;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.repositories.UserRepo;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public Optional<User> getUserById(
        @RequestParam(value = "id")
        Integer id
    ) {
        return userRepo.findById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
        @RequestBody
        RegisterRequest registerReq
    ) {
        if (userRepo.findByUsername(registerReq.getUsername()).isPresent())
            return new ResponseEntity<>("Username is already taken", HttpStatus.CONFLICT);


        //TODO: hash the password
        User user = new User(registerReq.getUsername(), registerReq.getPassword());

        userRepo.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
