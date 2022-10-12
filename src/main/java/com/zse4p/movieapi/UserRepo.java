package com.zse4p.movieapi;

import org.springframework.data.repository.CrudRepository;

import com.zse4p.movieapi.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {
    
}
