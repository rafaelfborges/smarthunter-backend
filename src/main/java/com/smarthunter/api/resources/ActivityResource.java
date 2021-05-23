package com.smarthunter.api.resources;

import com.smarthunter.api.contracts.requests.ActivityRequest;
import com.smarthunter.api.contracts.responses.ActivityResponse;
import com.smarthunter.api.services.impl.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityResource {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<Page<ActivityResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(activityService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityResponse findById(@PathVariable Long id) {
        return activityService.findById(id);
    }


    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse create(@Valid @RequestBody ActivityRequest activity) {
        return activityService.save(activity);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ActivityResponse update(@PathVariable Long id, @Valid @RequestBody ActivityRequest activity) {
        return activityService.updateById(id, activity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        activityService.deleteById(id);
    }
}
