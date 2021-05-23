package com.smarthunter.api.contracts.responses;

import com.smarthunter.api.entities.Activity;
import com.smarthunter.api.entities.Lesson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LessonResponse {

    @ApiModelProperty(value = "Lesson Id", example = "1", dataType = "integer")
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "Lesson Name", required = true, example = "Basic concepts", position = 1)
    private String name;

    @NotBlank
    @ApiModelProperty(value = "Lesson Description", required = true, example = "XYZ", position = 2)
    private String description;

    @ApiModelProperty(value = "Lesson Activities", required = true, dataType = "List", position = 3)
    private List<ActivityResponse> activities = new ArrayList<>();

    public LessonResponse(Lesson request) {
        this.id = request.getId();
        this.name = request.getName();
        this.description = request.getDescription();
        this.activities = request.getActivities().stream()
                .map(Activity::convert)
                .collect(Collectors.toList());
    }
}
