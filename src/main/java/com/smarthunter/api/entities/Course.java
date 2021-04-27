package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.dtos.responses.CourseResponseDTO;
import com.smarthunter.api.util.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course implements Convertible<CourseResponseDTO> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(required = true,example = "Course name")
    private String name;

    @Positive
    @ApiModelProperty(required = true,example = "0",dataType = "integer")
    private Long totalHours;

    @NotNull
    @ApiModelProperty(required = true,example = "true", dataType = "boolean")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true,example = "31-12-0000",dataType = "date-time")
    private LocalDate registerDate;

    @NotNull
    @Column(name = "expiration_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true,example = "31-12-0000",dataType = "date-time")
    private LocalDate expirationDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "courses_lessons",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> lessons = new ArrayList<>();

    @Override
    public CourseResponseDTO convertToDTO() {
        return new CourseResponseDTO(this);
    }
}
