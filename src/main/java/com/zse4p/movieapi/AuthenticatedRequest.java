package com.zse4p.movieapi;

import lombok.Data;

@Data
public class AuthenticatedRequest<T> {

    private String token;
    private T content;
}
