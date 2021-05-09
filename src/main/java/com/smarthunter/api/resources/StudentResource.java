package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.StudentRequest;
import com.smarthunter.api.contracts.responses.StudentResponse;
import com.smarthunter.api.resources.docs.StudentResourceDocs;
import com.smarthunter.api.services.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentResource implements StudentResourceDocs {

    private final StudentService studentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@Valid @RequestBody StudentRequest student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentRequest student) {
        if(!student.getPassword().isEmpty())
            student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        return studentService.updateById(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
