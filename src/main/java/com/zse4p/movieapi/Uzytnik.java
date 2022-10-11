package com.zse4p.movieapi;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Uzytnik {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @NonNull
    private String username;

    @Getter
    @NonNull
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Review> reviews;



}
