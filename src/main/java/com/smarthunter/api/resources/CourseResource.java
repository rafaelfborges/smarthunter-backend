package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.CourseRequest;
import com.smarthunter.api.contracts.responses.CourseResponse;
import com.smarthunter.api.resources.docs.CourseResourceDocs;
import com.smarthunter.api.services.impl.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseResource implements CourseResourceDocs {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(courseService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse findById(@PathVariable Long id) {
        return courseService.findById(id);
    }


    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CourseRequest course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse update(@PathVariable Long id, @Valid @RequestBody CourseRequest course) {
        return courseService.updateById(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
