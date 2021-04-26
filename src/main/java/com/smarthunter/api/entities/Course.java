package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.dtos.CourseResponseDTO;
import com.smarthunter.api.util.Convertible;
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
    private String name;

    @Positive
    private Long totalHours;

    @NotNull
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    @NotNull
    @Column(name = "expiration_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "courses_lessons",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> lessons = new ArrayList<>();

    @Override
    public CourseResponseDTO convertResponse() {
        return new CourseResponseDTO(this);
    }
}
