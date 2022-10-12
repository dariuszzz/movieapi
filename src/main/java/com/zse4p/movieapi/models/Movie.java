package com.zse4p.movieapi.models;


import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
@Getter
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String title;

    @NonNull
    private Integer releaseYear;

    @NonNull
    private String director;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Review> reviews;

}
