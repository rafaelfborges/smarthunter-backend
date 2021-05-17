package com.smarthunter.api.contracts.responses;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResponse {

    @ApiModelProperty(value = "User ID", example = "1", dataType = "integer")
    private Long id;

    @ApiModelProperty(value = "User Name", example = "John Doe", position = 1)
    private String name;

    @ApiModelProperty(value = "User E-mail", example = "johndoe@example.com", position = 2)
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(
            value = "User Registered Date", example = "31-12-0000", dataType = "date-time", position = 3
    )
    private LocalDate registerDate;

    @ApiModelProperty(value = "User Enrolled Courses", dataType = "List", position = 4)
    private List<EnrolledCourseResponse> enrolledCourses;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.registerDate = entity.getRegisterDate();
        this.enrolledCourses = entity.getEnrolledCourses().stream()
                .map(EnrolledCourse::convert)
                .collect(Collectors.toList());
    }
}
