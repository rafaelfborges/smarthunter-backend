package com.smarthunter.api.services.impl;

import com.smarthunter.api.contracts.requests.EnrolledCourseRequest;
import com.smarthunter.api.contracts.responses.EnrolledCourseResponse;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.repositories.EnrolledCourseRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnrolledCourseService implements GenericService<EnrolledCourse, EnrolledCourseResponse, EnrolledCourseRequest, Long> {

    private final EnrolledCourseRepository enrolledCourseRepository;

    @Override
    public JpaRepository<EnrolledCourse, Long> getRepository() {
        return enrolledCourseRepository;
    }
}
