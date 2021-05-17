package com.smarthunter.api.services.impl;


import com.smarthunter.api.contracts.requests.UserRequest;
import com.smarthunter.api.contracts.responses.UserResponse;
import com.smarthunter.api.entities.User;
import com.smarthunter.api.repositories.UserRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService, GenericService<User, UserResponse, UserRequest, Long> {

    private final UserRepository userRepository;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not exists"));
    }
}
