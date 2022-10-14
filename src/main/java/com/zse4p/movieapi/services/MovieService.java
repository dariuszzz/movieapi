package com.zse4p.movieapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.zse4p.movieapi.models.Movie;
import com.zse4p.movieapi.repositories.MovieRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();

        movieRepo.findAll().forEach(movies::add);

        return movies;
    }

    public List<Movie> getByCriteria(String title, String director, Integer year) {
        List<Movie> movies = new ArrayList<Movie>();

        if (year != null) movieRepo.findByCriteria(title, director, year).forEach(movies::add);
        else movieRepo.findByCriteriaWithoutYear(title, director).forEach(movies::add);

        return movies;
    }


}
