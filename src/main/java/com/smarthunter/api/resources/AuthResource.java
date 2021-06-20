package com.smarthunter.api.resources;

import com.smarthunter.api.configs.TokenService;
import com.smarthunter.api.contracts.requests.LoginRequest;
import com.smarthunter.api.contracts.responses.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthResource {

    private final TokenService tokenService;
    private final AuthenticationManager authManager;

    @PostMapping
    public ResponseEntity<TokenResponse> autenticate(@RequestBody @Valid LoginRequest request) {
        UsernamePasswordAuthenticationToken login = request.convert();

        try {
            Authentication authentication = authManager.authenticate(login);
            String token = tokenService.tokenGenerator(authentication);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
