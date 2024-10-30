package com.ibt.StackUp.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails
    );

    boolean isTokenValid(String jwt, UserDetails userDetails);
}
