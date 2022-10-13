package com.zse4p.movieapi;

import java.time.Duration;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class jwtUtil {
    private final static String SECRET = "siema";
    private final static Algorithm ALG = Algorithm.HMAC256(SECRET);

    public static String createToken(String username) {

        try {
            String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(Instant.now().plus(Duration.ofHours(1L)))
                .sign(ALG);
                
            return token;
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "JWT creation failed");
        }

    }

    public static DecodedJWT decode(String jwt) {
        try {
            JWTVerifier verifier = JWT.require(ALG).build();
    
            return verifier.verify(jwt);
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "JWT validation failed");
        }
    }
}
