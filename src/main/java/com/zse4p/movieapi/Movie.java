package com.zse4p.movieapi;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @NonNull
    private String title;

    @Getter
    @NonNull
    private Integer release_year;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Review> reviews;

}
