package com.scisw.phonecontacts.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractLogin(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
