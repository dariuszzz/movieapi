package com.zse4p.movieapi;


import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

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
    private int release_year;
}
