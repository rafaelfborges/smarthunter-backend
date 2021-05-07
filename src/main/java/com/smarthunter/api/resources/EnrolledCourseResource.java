package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.EnrolledCourseRequest;
import com.smarthunter.api.contracts.responses.EnrolledCourseResponse;
import com.smarthunter.api.resources.docs.EnrolledCourseResourceDocs;
import com.smarthunter.api.services.impl.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/enrolled_courses")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnrolledCourseResource implements EnrolledCourseResourceDocs {

    private final EnrolledCourseService enrolledCourseService;

    @GetMapping
    public ResponseEntity<Page<EnrolledCourseResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(enrolledCourseService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrolledCourseResponse findById(@PathVariable Long id) {
        return enrolledCourseService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EnrolledCourseResponse create(@Valid @RequestBody EnrolledCourseRequest student) {
        return enrolledCourseService.save(student);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EnrolledCourseResponse update(@PathVariable Long id, @Valid @RequestBody EnrolledCourseRequest student) {
        return enrolledCourseService.updateById(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        enrolledCourseService.deleteById(id);
    }
}
