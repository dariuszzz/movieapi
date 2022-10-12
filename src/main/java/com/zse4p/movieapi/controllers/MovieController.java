package com.zse4p.movieapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zse4p.movieapi.MovieSearchRequest;
import com.zse4p.movieapi.models.Movie;
import com.zse4p.movieapi.services.MovieService;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies(
        @RequestBody(required = false)
        MovieSearchRequest searchOptions
    ) {
        if (searchOptions == null) return movieService.getAllMovies();

        String title = searchOptions.getTitle() == null ? "" : searchOptions.getTitle();
        String director = searchOptions.getDirector() == null ? "" : searchOptions.getDirector();

        return movieService.getByCriteria(title, director, searchOptions.getReleaseYear());

    }
}
