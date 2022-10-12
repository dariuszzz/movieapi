package com.zse4p.movieapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zse4p.movieapi.models.Movie;
import org.springframework.data.repository.query.Param;

public interface MovieRepo extends CrudRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM movies WHERE " +
                   "LOWER(title) LIKE CONCAT('%', LOWER(?1), '%') AND " +
                   "LOWER(director) LIKE CONCAT('%', LOWER(?2), '%') " +
                   "AND release_year = ?3", nativeQuery = true)
    Iterable<Movie> findByCriteria(String title, String director, Integer year);

    @Query(value = "SELECT * FROM movies WHERE " +
                   "LOWER(title) LIKE CONCAT('%', LOWER(?1), '%') AND " +
                   "LOWER(director) LIKE CONCAT('%', LOWER(?2), '%')", nativeQuery = true)
    Iterable<Movie> findByCriteriaWithoutYear(String title, String director);
}
