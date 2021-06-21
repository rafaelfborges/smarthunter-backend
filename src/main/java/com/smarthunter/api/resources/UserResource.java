package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.UserRequest;
import com.smarthunter.api.contracts.responses.UserResponse;
import com.smarthunter.api.resources.docs.UserResourceDocs;
import com.smarthunter.api.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResource implements UserResourceDocs {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserRequest user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.updateById(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
