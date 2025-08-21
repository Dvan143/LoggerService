package org.dmitriyprojects.bankapploggingservice.db.h2;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenService {
    @Value("${loggingService.secret.value}")
    private String secret;
    @Value("${loggingService.secret.expiration}")
    private long expirationTime;

    public String generateToken(String username) {
        return Jwts.builder().subject(username).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+expirationTime*1000*60*60*24)).signWith(getKey()).compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public boolean verifyToken(String token) {
        if(token==null) return false;
        return !isTokenExpired(token);
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
