package com.smarthunter.api.services.impl;

import com.smarthunter.api.contracts.requests.ActivityRequest;
import com.smarthunter.api.contracts.responses.ActivityResponse;
import com.smarthunter.api.entities.Activity;
import com.smarthunter.api.repositories.ActivityRepository;
import com.smarthunter.api.services.interfaces.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityService implements GenericService<Activity, ActivityRequest, ActivityResponse, Long> {

    private final ActivityRepository activityRepository;

    @Override
    public JpaRepository<Activity, Long> getRepository() {
        return activityRepository;
    }
}
