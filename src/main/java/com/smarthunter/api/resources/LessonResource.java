package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.LessonRequest;
import com.smarthunter.api.contracts.responses.LessonResponse;
import com.smarthunter.api.services.impl.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonResource {

    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<Page<LessonResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(lessonService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonResponse findById(@PathVariable Long id) {
        return lessonService.findById(id);
    }


    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public LessonResponse create(@Valid @RequestBody LessonRequest lesson) {
        return lessonService.save(lesson);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public LessonResponse update(@PathVariable Long id, @Valid @RequestBody LessonRequest lesson) {
        return lessonService.updateById(id, lesson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        lessonService.deleteById(id);
    }
}
