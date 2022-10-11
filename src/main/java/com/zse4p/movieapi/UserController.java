package com.zse4p.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public Optional<Uzytnik> getUserById(
            @RequestParam(value = "id")
            Integer id
    ) {
        return userRepo.findById(id);
    }
}
