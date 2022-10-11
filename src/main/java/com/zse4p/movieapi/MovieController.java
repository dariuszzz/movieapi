package com.zse4p.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies(
//            @RequestParam(value = "title", defaultValue = "Movie")
//            String title,
//            @RequestParam(value = "year", defaultValue = "2022")
//            int year
    ) {
        return movieService.getAllMovies();
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
