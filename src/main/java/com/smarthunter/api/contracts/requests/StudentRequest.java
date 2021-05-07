package com.smarthunter.api.contracts.requests;

import com.smarthunter.api.entities.Student;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentRequest implements Convertible<Student> {

    @NotBlank
    @ApiModelProperty(required = true, example = "Student name")
    private String name;

    @NotBlank
    @ApiModelProperty(required = true, example = "Student e-mail")
    private String email;

    @NotBlank
    @ApiModelProperty(required = true, example = "Student password")
    private String password;

    @Override
    public Student convert() {
        return new Student(this);
    }
}
