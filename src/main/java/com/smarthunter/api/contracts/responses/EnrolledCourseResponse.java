package com.smarthunter.api.contracts.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnrolledCourseResponse {
    private Long id;

    @JsonIgnoreProperties({"name", "totalHours", "isActive", "registerDate", "expirationDate", "lessons"})
    private Course course;

    @JsonIgnoreProperties({"name", "email", "password", "registerDate", "enrolledCourses"})
    private Student student;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    public EnrolledCourseResponse(EnrolledCourse entity) {
        this.id = entity.getId();
        this.course = entity.getCourse();
        this.student = entity.getStudent();
        this.registerDate = entity.getRegisterDate();
    }
}
