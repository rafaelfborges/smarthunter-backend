package com.smarthunter.api.services.impl;


import com.smarthunter.api.contracts.requests.CourseRequest;
import com.smarthunter.api.contracts.responses.CourseResponse;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.repositories.CourseRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService implements GenericService<Course, CourseResponse, CourseRequest, Long> {

    private final CourseRepository courseRepository;

    @Override
    public JpaRepository<Course, Long> getRepository() {
        return courseRepository;
    }
}