package com.smarthunter.api.services.impl;

import com.smarthunter.api.contracts.requests.LessonRequest;
import com.smarthunter.api.contracts.responses.LessonResponse;
import com.smarthunter.api.entities.Lesson;
import com.smarthunter.api.repositories.LessonRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonService implements GenericService<Lesson, LessonRequest, LessonResponse, Long> {

    private final LessonRepository lessonRepository;

    @Override
    public JpaRepository<Lesson, Long> getRepository() {
        return lessonRepository;
    }
}
