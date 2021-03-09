package com.openedu.mscourses.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Course {

    private Long id;
    private String name;
    private List<Lesson> lessons;
    private Long totalHours;
    private Boolean isActive;
    private LocalDate registerDate;
    private LocalDate expirationDate;
}
