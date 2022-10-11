package com.zse4p.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> movies(
//            @RequestParam(value = "title", defaultValue = "Movie")
//            String title,
//            @RequestParam(value = "year", defaultValue = "2022")
//            int year
    ) {
        return movieService.getAllMovies();
    }

}
