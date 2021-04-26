package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.dtos.StudentResponseDTO;
import com.smarthunter.api.util.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student implements Convertible<StudentResponseDTO> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<EnrolledCourse> enrolledCourses = new ArrayList<>();

    public boolean newEnrolledCourse(EnrolledCourse enrolledCourse) {
        return this.enrolledCourses.add(enrolledCourse);
    }

    @Override
    public StudentResponseDTO convertResponse() {
        return new StudentResponseDTO(this);
    }
}
