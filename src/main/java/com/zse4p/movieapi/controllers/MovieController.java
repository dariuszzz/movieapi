package com.zse4p.movieapi.controllers;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zse4p.movieapi.AuthenticatedRequest;
import com.zse4p.movieapi.MovieSearchRequest;
import com.zse4p.movieapi.models.Movie;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.services.MovieService;
import com.zse4p.movieapi.services.UserService;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(
        @RequestBody(required = false)
        AuthenticatedRequest<MovieSearchRequest> searchOpts
    ) {
        Pair<User, MovieSearchRequest> authorized = userService.validateAuthenticatedRequest(searchOpts, true);

        MovieSearchRequest searchOptions = authorized.getValue1();

        if (searchOptions == null) 
            return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);

        String title = searchOptions.getTitle() == null ? "" : searchOptions.getTitle();
        String director = searchOptions.getDirector() == null ? "" : searchOptions.getDirector();

        List<Movie> movies = movieService.getByCriteria(title, director, searchOptions.getReleaseYear());

        return new ResponseEntity<>(
            movies, 
            HttpStatus.OK
        );
    }
}
