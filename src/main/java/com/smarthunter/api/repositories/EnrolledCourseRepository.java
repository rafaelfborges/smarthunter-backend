package com.smarthunter.api.repositories;

import com.smarthunter.api.entities.EnrolledCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse, Long> {

}
