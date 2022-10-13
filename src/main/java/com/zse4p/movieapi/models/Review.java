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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Getter
    @NonNull
    private Movie movie;

    @Getter
    @Setter
    @NonNull
    private String content;

    @Getter
    @Setter
    @NonNull
    private Short rating;

    @Getter
    @Setter
    private Integer likes = 0;
}
