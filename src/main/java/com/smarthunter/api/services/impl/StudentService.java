package com.smarthunter.api.services.impl;


import com.smarthunter.api.entities.EnrolledCourses;
import com.smarthunter.api.entities.Student;
import com.smarthunter.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}
