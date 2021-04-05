package com.smarthunter.api.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class EnrolledCoursesId implements Serializable {

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
