package com.scisw.phonecontacts.service.impl;

import com.scisw.phonecontacts.repository.UserRepository;
import com.scisw.phonecontacts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String login) {
                return userRepository.findByLogin(login)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}