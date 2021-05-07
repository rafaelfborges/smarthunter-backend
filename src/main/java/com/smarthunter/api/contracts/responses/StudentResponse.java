package com.smarthunter.api.contracts.responses;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class StudentResponse {

    private Long id;

    @ApiModelProperty(required = true, example = "Student name")
    private String name;

    @ApiModelProperty(required = true, example = "Student e-mail")
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true, example = "31-12-0000", dataType = "date-time")
    private LocalDate registerDate;

    @ApiModelProperty(dataType = "List")
    private List<EnrolledCourseResponse> enrolledCourses;

    public StudentResponse(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.registerDate = entity.getRegisterDate();
        this.enrolledCourses = entity.getEnrolledCourses().stream()
                .map(EnrolledCourse::convert)
                .collect(Collectors.toList());
    }
}
