package com.smarthunter.api.contracts.requests;

import com.smarthunter.api.entities.Lesson;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LessonRequest implements Convertible<Lesson> {

    @NotBlank
    @ApiModelProperty(value = "Lesson Name", required = true, example = "Basic concepts", position = 1)
    private String name;

    @NotBlank
    @ApiModelProperty(value = "Lesson Description", required = true, example = "XYZ", position = 2)
    private String description;

    @Override
    public Lesson convert() {
        return new Lesson(this);
    }
}
