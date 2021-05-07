package com.smarthunter.api.contracts.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.Lesson;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CourseRequest implements Convertible<Course> {

    @NotBlank
    @ApiModelProperty(required = true, example = "Course name")
    private String name;

    @Positive
    @ApiModelProperty(required = true, example = "0", dataType = "integer")
    private Long totalHours;

    @NotNull
    @ApiModelProperty(required = true, example = "true", dataType = "boolean")
    private Boolean isActive;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true, example = "31-12-0000", dataType = "date-time")
    private LocalDate expirationDate;

    @ApiModelProperty(dataType = "List")
    private List<Lesson> lessons;

    @Override
    public Course convert() {
        return new Course(this);
    }
}
