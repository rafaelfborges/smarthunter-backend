package com.smarthunter.api.contracts.requests;

import com.smarthunter.api.entities.Activity;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ActivityRequest implements Convertible<Activity> {

    @NotBlank
    @ApiModelProperty(
            required = true, value = "Activity Title", example = "Java History", dataType = "integer", position = 1
    )
    private String title;

    @NotBlank
    @ApiModelProperty(
            required = true, value = "Activity Video URL", example = "https://vimeo.com/23901832", position = 2
    )
    private String urlVideo;

    @Override
    public Activity convert() {
        return new Activity(this);
    }
}
