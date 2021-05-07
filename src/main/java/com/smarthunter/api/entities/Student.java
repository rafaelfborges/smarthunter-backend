package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.contracts.requests.StudentRequest;
import com.smarthunter.api.contracts.responses.StudentResponse;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
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
public class Student implements Convertible<StudentResponse> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(required = true, example = "Student name")
    private String name;

    @NotBlank
    @ApiModelProperty(required = true, example = "Student e-mail")
    private String email;

    @NotBlank
    @ApiModelProperty(required = true, example = "Student password")
    private String password;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true, example = "31-12-0000", dataType = "date-time")
    private LocalDate registerDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<EnrolledCourse> enrolledCourses = new ArrayList<>();

    public Student(StudentRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }

    @Override
    public StudentResponse convert() {
        return new StudentResponse(this);
    }
}
