package com.smarthunter.api.dtos.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentRequestDTO {

    @NotBlank
    @ApiModelProperty(required = true,example = "Student name")
    private String name;

    @NotBlank
    @ApiModelProperty(required = true,example = "Student e-mail")
    private String email;

    @NotBlank
    @ApiModelProperty(required = true,example = "Student password")
    private String password;
}
