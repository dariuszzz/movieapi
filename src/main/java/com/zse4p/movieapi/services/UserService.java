package com.zse4p.movieapi.services;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zse4p.movieapi.AuthenticatedRequest;
import com.zse4p.movieapi.jwtUtil;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public <T> Pair<User, T> validateAuthenticatedRequest(AuthenticatedRequest<T> req) {
        return validateAuthenticatedRequest(req, false);
    }

    public <T> Pair<User, T> validateAuthenticatedRequest(AuthenticatedRequest<T> req, boolean optionalContent) {
        String token = req.getToken();
        T content = req.getContent();
        
        if (!optionalContent && content == null) 
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Content required");

        if (token == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "JWT required"); 
        
        DecodedJWT jwt = jwtUtil.decode(token);

        if (jwt.getExpiresAt().before(Date.from(Instant.now()))) 
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "JWT expired");
        
        String username = jwt.getSubject();

        Optional<User> user = userRepo.findByUsername(username);

        if (user.isEmpty()) 
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "JWT invalid");

        return Pair.with(user.get(), content);
    }



}
