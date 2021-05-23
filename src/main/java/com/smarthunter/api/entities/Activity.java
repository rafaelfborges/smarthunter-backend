package com.smarthunter.api.entities;

import com.smarthunter.api.contracts.requests.ActivityRequest;
import com.smarthunter.api.contracts.responses.ActivityResponse;
import com.smarthunter.api.utils.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Activity implements Serializable, Convertible<ActivityResponse> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String urlVideo;

    public Activity(ActivityRequest request) {
        this.title = request.getTitle();
        this.urlVideo = request.getUrlVideo();
    }

    @Override
    public ActivityResponse convert() {
        return new ActivityResponse(this);
    }
}
