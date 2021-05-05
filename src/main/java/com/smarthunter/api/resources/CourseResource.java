package com.smarthunter.api.resources;

import com.smarthunter.api.dtos.requests.CourseRequestDTO;
import com.smarthunter.api.dtos.responses.CourseResponseDTO;
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
@RequestMapping("api/courses")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseResource implements CourseResourceDocs {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(courseService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponseDTO findById(@PathVariable Long id) {
        return courseService.findById(id);
    }


    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseDTO create(@Valid @RequestBody CourseRequestDTO course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CourseResponseDTO update(@PathVariable Long id, @Valid @RequestBody CourseRequestDTO course) {
        return courseService.updateById(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
