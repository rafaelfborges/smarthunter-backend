package com.smarthunter.api.services.impl;

import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return studentRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not exists"));
    }
}
