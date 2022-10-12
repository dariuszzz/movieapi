package com.zse4p.movieapi.models;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {
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
