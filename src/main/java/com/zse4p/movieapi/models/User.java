package com.zse4p.movieapi.models;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zse4p.movieapi.UserRole;

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

    @Getter
    @Setter
    @Enumerated
    public UserRole role = UserRole.User;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
