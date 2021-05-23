package com.smarthunter.api.entities;

import com.smarthunter.api.contracts.requests.LessonRequest;
import com.smarthunter.api.contracts.responses.LessonResponse;
import com.smarthunter.api.utils.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lessons")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lesson implements Serializable, Convertible<LessonResponse> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "lesson_activities",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities = new ArrayList<>();

    public Lesson(LessonRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
    }

    @Override
    public LessonResponse convert() {
        return new LessonResponse(this);
    }
}
