package com.smarthunter.api.services.impl;


import com.smarthunter.api.dtos.requests.CourseRequestDTO;
import com.smarthunter.api.dtos.responses.CourseResponseDTO;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.repositories.CourseRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService implements GenericService<Course, CourseResponseDTO, CourseRequestDTO, Long> {

    private final CourseRepository courseRepository;

    @Override
    public JpaRepository<Course, Long> getRepository() {
        return courseRepository;
    }
}