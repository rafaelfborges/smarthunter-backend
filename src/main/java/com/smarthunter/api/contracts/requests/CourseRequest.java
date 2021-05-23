package com.smarthunter.api.contracts.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class CourseRequest implements Convertible<Course> {

    @NotBlank
    @ApiModelProperty(value = "Course Name", example = "Java Course")
    private String name;

    @Positive
    @ApiModelProperty(value = "Course Total Hours", required = true, example = "1", dataType = "integer", position = 1)
    private Long totalHours;

    @NotNull
    @ApiModelProperty(value = "Course Status", required = true, example = "true", dataType = "boolean", position = 2)
    private Boolean isActive;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(
            value = "Course Expiration", required = true, example = "31-12-0000", dataType = "date-time", position = 3
    )
    private LocalDate expirationDate;

    @Override
    public Course convert() {
        return new Course(this);
    }
}
