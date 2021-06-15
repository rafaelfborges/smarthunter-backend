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
    @ApiModelProperty(value = "Course Name", example = "Java Course")
    private String name;

    @Positive
    @ApiModelProperty(value = "Course Total Hours", required = true, example = "1", dataType = "integer", position = 1)
    private Long totalHours;

    @NotNull
    @ApiModelProperty(value = "Course Status", required = true, example = "true", dataType = "boolean", position = 2)
    private Boolean isActive;

    @NotNull
    @ApiModelProperty(value = "Course Description", required = true, example = "This is a advanced course...", position = 3)
    private String description;

    @NotNull
    @ApiModelProperty(value = "Course Thumbnail", required = true, example = "http://images.domain.com/thumbnail-1.jpg", position = 4)
    private String thumbUrl;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(
            value = "Course Expiration", required = true, example = "31-12-0000", dataType = "date-time", position = 5
    )
    private LocalDate expirationDate;

    @ApiModelProperty(value = "Course Lessons", dataType = "List", position = 6)
    private List<Lesson> lessons;

    @Override
    public Course convert() {
        return new Course(this);
    }
}
