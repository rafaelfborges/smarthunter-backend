package com.smarthunter.api.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Lesson;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CourseRequestDTO {

    @NotBlank
    private String name;

    @Positive
    private Long totalHours;

    @NotNull
    private Boolean isActive;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    private List<Lesson> lessons;
}
