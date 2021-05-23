package com.smarthunter.api.contracts.responses;

import com.smarthunter.api.entities.Activity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ActivityResponse {

    @ApiModelProperty(value = "Activity Id", example = "1", dataType = "integer")
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "Activity Title", example = "Java History", dataType = "integer", position = 1)
    private String title;

    @NotBlank
    @ApiModelProperty(value = "Activity Video URL", example = "https://vimeo.com/23901832", position = 2)
    private String urlVideo;

    public ActivityResponse(Activity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.urlVideo = entity.getUrlVideo();
    }
}
