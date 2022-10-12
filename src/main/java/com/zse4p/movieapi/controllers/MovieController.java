package com.zse4p.movieapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zse4p.movieapi.MovieSearchRequest;
import com.zse4p.movieapi.MovieService;
import com.zse4p.movieapi.models.Movie;

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

//    @PostMapping("/postReview")
//    public void postReview(
//            @RequestParam(value = "movie_id")
//            Integer movie_id,
//            @RequestParam(value = "content")
//            String content,
//            @RequestParam(value = "rating")
//            Short rating
//    ) {
//        Review review = new Review()
//    }

}
