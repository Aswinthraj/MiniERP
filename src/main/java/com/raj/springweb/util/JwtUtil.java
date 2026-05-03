package com.raj.springweb.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "raj_secret_key_which_is_long_and_secure_123456";


    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String username,String role) {
        return Jwts.builder()
                .subject(username)
                .claim("role",role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }
    public static String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }
    public static String extractRole(String token){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role",String.class);
    }
    public static boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e){
            return false;
        }
    }
}