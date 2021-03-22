package com.smarthunter.services.impl;


import com.smarthunter.entities.Course;
import com.smarthunter.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course save(Course course) {
        return repository.save(course);
    }
}