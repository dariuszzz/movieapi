package com.zse4p.movieapi;

import lombok.Data;

@Data
public class MovieSearchRequest {
    private String title;
    private Integer releaseYear;
    private String director;
}
