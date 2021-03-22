package com.smarthunter.resources;

import com.smarthunter.entities.Course;
import com.smarthunter.services.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseResource {

    @Autowired
    private CourseServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody Course course) {
        return service.save(course);
    }
}
