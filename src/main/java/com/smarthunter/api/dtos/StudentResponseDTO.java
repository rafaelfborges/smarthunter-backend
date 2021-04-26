package com.smarthunter.api.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class StudentResponseDTO {

    private Long id;

    private String name;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    private List<EnrolledCourse> enrolledCourses;

    public StudentResponseDTO(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.registerDate = entity.getRegisterDate();
        this.enrolledCourses = entity.getEnrolledCourses();
    }
}
