package com.zse4p.movieapi.controllers;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.zse4p.movieapi.AuthenticatedRequest;
import com.zse4p.movieapi.RegisterRequest;
import com.zse4p.movieapi.jwtUtil;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.repositories.UserRepo;
import com.zse4p.movieapi.services.UserService;

import java.util.HashMap;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getUserById(
        @PathVariable
        Integer id
    ) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
        @RequestBody
        RegisterRequest registerReq
    ) {
        if (userService.findByUsername(registerReq.getUsername()).isPresent())
            return new ResponseEntity<>("Username is already taken", HttpStatus.CONFLICT);

        String username = registerReq.getUsername();
        String password = registerReq.getPassword();


        //TODO: hash the password
        User user = new User(username, password);

        try {
            String token = jwtUtil.createToken(username);

            userService.save(user);
    
            return new ResponseEntity<>(token, HttpStatus.OK);
            
        } catch (JWTCreationException e) {

            return new ResponseEntity<>("Token creation failed", HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(
        @RequestBody
        RegisterRequest registerReq
    ) {
        String username = registerReq.getUsername();
        String password = registerReq.getPassword();
        
        Optional<User> user_opt = userService.findByUsername(username);

        if (user_opt.isEmpty()) 
            return new ResponseEntity<>("Invalid username", HttpStatus.BAD_REQUEST);
        
        User user = user_opt.get();

        if (!user.getPassword().equals(password)) 
            return new ResponseEntity<>("Invalid password", HttpStatus.BAD_REQUEST);

        try {
            String token = jwtUtil.createToken(username);
            
            return new ResponseEntity<>(token, HttpStatus.OK);

        } catch (JWTCreationException e) {

            return new ResponseEntity<>("Token creation failed", HttpStatus.BAD_REQUEST);
        }
    }
}
