package com.zse4p.movieapi.models;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @Getter
    @NonNull
    private User author;

    @Getter
    @NonNull
    private String content;

    @Getter
    @NonNull
    private Short rating;

    @Getter
    @Setter
    private Integer likes = 0;
}
