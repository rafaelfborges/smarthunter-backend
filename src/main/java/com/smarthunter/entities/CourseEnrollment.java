package com.smarthunter.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Course course;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;
}
