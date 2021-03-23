package com.smarthunter.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class CourseEnrollmentId implements Serializable {

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;
}
