package com.smarthunter.api.services.impl;


import com.smarthunter.api.contracts.requests.StudentRequest;
import com.smarthunter.api.contracts.responses.StudentResponse;
import com.smarthunter.api.entities.Student;
import com.smarthunter.api.repositories.StudentRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService implements GenericService<Student, StudentResponse, StudentRequest, Long> {

    private final StudentRepository studentRepository;

    @Override
    public JpaRepository<Student, Long> getRepository() {
        return studentRepository;
    }
}
