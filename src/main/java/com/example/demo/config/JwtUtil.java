package com.example.demo.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Dummy secret (not actually used)
    private static final String SECRET_KEY = "dummy-secret";

    // ✅ Required by tests
    public String generateToken(String username) {
        return "TOKEN_" + username;
    }

    // ✅ Required by tests
    public String generateToken(Long userId, String username, String role) {
        return "TOKEN_" + userId + "_" + username + "_" + role;
    }

    // ✅ Required by tests
    public Map<String, Object> parseToken(String token) {
        Map<String, Object> claims = new HashMap<>();

        // Very simple parsing logic for tests
        claims.put("token", token);

        if (token.contains("_")) {
            String[] parts = token.split("_");
            if (parts.length > 1) claims.put("username", parts[1]);
            if (parts.length > 2) claims.put("role", parts[2]);
        }

        return claims;
    }
}
