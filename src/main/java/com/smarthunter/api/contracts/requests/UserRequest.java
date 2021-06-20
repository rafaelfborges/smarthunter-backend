package com.smarthunter.api.contracts.requests;

import com.smarthunter.api.entities.User;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest implements Convertible<User> {

    @NotBlank
    @ApiModelProperty(value = "User Name and Surname", required = true, example = "John Doe")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "User E-mail", required = true, example = "johndoe@example.com", position = 1)
    private String email;

    @NotBlank
    @ApiModelProperty(value = "User Password", required = true, example = "P4ssW0rd@321", position = 2)
    private String password;

    @Override
    public User convert() {
        this.password = new BCryptPasswordEncoder().encode(password);
        return new User(this);
    }
}
