package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnrolledCoursesId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"name", "username", "email", "registerDate", "enrolledCourses"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"name", "totalHours", "isActive", "registerDate", "expirationDate", "lessons"})
    private Course course;
}
