package com.smarthunter.api.dtos.responses;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class StudentResponseDTO {

    private Long id;
    @ApiModelProperty(required = true,example = "Student name")
    private String name;

    @ApiModelProperty(required = true,example = "Student e-mail")
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true,example = "31-12-0000",dataType = "date-time")
    private LocalDate registerDate;

    @ApiModelProperty(dataType = "List")
    private List<EnrolledCourse> enrolledCourses;

    public StudentResponseDTO(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.registerDate = entity.getRegisterDate();
        this.enrolledCourses = entity.getEnrolledCourses();
    }
}
