package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.contracts.requests.CourseRequest;
import com.smarthunter.api.contracts.responses.CourseResponse;
import com.smarthunter.api.utils.Convertible;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course implements Serializable, Convertible<CourseResponse> {

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

    @NotNull
    private String description;

    @NotNull
    private String thumbUrl;

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
            name = "course_lessons",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private Set<Lesson> lessons = new HashSet<>();

    public Course(CourseRequest request) {
        this.name = request.getName();
        this.totalHours = request.getTotalHours();
        this.isActive = request.getIsActive();
        this.description = request.getDescription();
        this.thumbUrl = request.getThumbUrl();
        this.expirationDate = request.getExpirationDate();
        this.lessons = new HashSet<>(request.getLessons());
    }

    @Override
    public CourseResponse convert() {
        return new CourseResponse(this);
    }
}
