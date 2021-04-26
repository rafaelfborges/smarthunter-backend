package com.smarthunter.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.Lesson;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {
    private Long id;
    private String name;
    private Long totalHours;
    private Boolean isActive;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;
    private List<Lesson> lessons;

    public CourseResponseDTO(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.totalHours = entity.getTotalHours();
        this.isActive = entity.getIsActive();
        this.registerDate = entity.getRegisterDate();
        this.expirationDate = entity.getExpirationDate();
        this.lessons = entity.getLessons();
    }
}
