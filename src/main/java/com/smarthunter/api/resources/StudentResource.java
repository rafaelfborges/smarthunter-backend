package com.smarthunter.api.resources;

import com.smarthunter.api.dtos.StudentRequestDTO;
import com.smarthunter.api.dtos.StudentResponseDTO;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.resources.docs.StudentResourceDocs;
import com.smarthunter.api.services.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentResource implements StudentResourceDocs {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDTO create(@Valid @RequestBody StudentRequestDTO student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO update(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO student) {
        return studentService.updateById(id, student);
    }

    @PutMapping("/{id}/enrolled_courses/new")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO newEnrolledCourse(@PathVariable Long id, @Valid @RequestBody EnrolledCourse enrolledCourse) {
        return studentService.newEnrolledCourse(id, enrolledCourse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
