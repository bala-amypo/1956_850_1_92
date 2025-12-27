// package com.example.demo.config;

// import org.springframework.stereotype.Component;

// @Component
// public class JwtUtil {

//     public String generateToken(String username) {
//         return "TOKEN_" + username;
//     }

//     public String generateToken(Long userId, String username, String role) {
//         return "TOKEN_" + userId + "_" + username + "_" + role;
//     }

//     public Claims parseToken(String token) {
//         Claims claims = new Claims();

//         if (token == null) {
//             return claims;
//         }

//         String[] parts = token.split("_");

//         if (parts.length == 2) {
//             claims.put("username", parts[1]);
//         }

//         if (parts.length == 4) {
//             claims.put("userId", Long.parseLong(parts[1]));
//             claims.put("username", parts[2]);
//             claims.put("role", parts[3]);
//         }

//         return claims;
//     }
// }

package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 86400000; // 24 hours
    
    public String generateToken(Long userId, String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);
        
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact();
    }
    
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}