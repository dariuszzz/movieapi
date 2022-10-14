package com.zse4p.movieapi.models;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Column(unique = true)
    @Getter
    @NonNull
    private String username;
    
    @Getter
    @JsonIgnore
    @NonNull
    private String password;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    public List<Review> reviews;



}
