package com.smarthunter.api.contracts.requests;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import com.smarthunter.api.utils.Convertible;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnrolledCourseRequest implements Convertible<EnrolledCourse> {

    @NotNull
    @JsonIgnoreProperties({"name", "totalHours", "isActive", "registerDate", "expirationDate", "lessons"})
    private Course course;

    @NotNull
    @JsonIgnoreProperties({"name", "email", "password", "registerDate", "enrolledCourses"})
    private Student student;

    @Override
    public EnrolledCourse convert() {
        return new EnrolledCourse(this);
    }
}
