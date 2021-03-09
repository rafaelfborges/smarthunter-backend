package com.openedu.mscourses.entities;

import lombok.Data;

import java.util.List;

@Data
public class Lesson {

    private Long id;
    private String name;
    private String description;
    private List<Activity> activities;
}
