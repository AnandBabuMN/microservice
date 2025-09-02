package com.course.course_service.config;


import io.jsonwebtoken.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtil {
    private final String SECRET = "mysecretkey123456";

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token).getBody().getSubject();
    }

    public List<SimpleGrantedAuthority> extractRoles(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token).getBody();
        String role = claims.get("roles").toString(); // stored as ROLE_ADMIN or ROLE_STAFF
        return List.of(new SimpleGrantedAuthority(role));
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}




