package com.zse4p.movieapi.models;


import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Getter
    @NonNull
    private String title;

    @Getter
    @NonNull
    private Integer releaseYear;

    @Getter
    @NonNull
    private String director;

    @Getter
    @OneToMany(fetch = FetchType.LAZY)
    public List<Review> reviews;

}
