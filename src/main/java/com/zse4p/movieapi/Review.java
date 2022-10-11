package com.zse4p.movieapi;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @Getter
    @NonNull
    private Uzytnik author;

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
