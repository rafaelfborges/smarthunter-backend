package com.smarthunter.api.services.impl;


import com.smarthunter.api.dtos.StudentRequestDTO;
import com.smarthunter.api.dtos.StudentResponseDTO;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.entities.Student;
import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.repositories.StudentRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService implements GenericService<Student, StudentResponseDTO, StudentRequestDTO, Long> {

    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDTO save(StudentRequestDTO request) {
        var student = new Student();
        BeanUtils.copyProperties(request, student);
        return studentRepository.save(student).convertResponse();
    }

    @Override
    public JpaRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    public StudentResponseDTO newEnrolledCourse(Long id, EnrolledCourse enrolledCourse) {
        var student = studentRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        student.newEnrolledCourse(enrolledCourse);
        return studentRepository.save(student).convertResponse();
    }
}
