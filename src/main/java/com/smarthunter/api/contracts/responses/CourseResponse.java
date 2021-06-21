package com.smarthunter.api.contracts.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.Lesson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CourseResponse {

    @ApiModelProperty(value = "Course Id", example = "1", dataType = "integer")
    private Long id;

    @ApiModelProperty(value = "Course Name", example = "Java Course", position = 1)
    private String name;

    @ApiModelProperty(value = "Course Total Hours", example = "1", dataType = "integer", position = 2)
    private Long totalHours;

    @ApiModelProperty(value = "Course Status", example = "true", dataType = "boolean", position = 3)
    private Boolean isActive;

    @NotNull
    @ApiModelProperty(value = "Course Description", example = "This is a advanced course...", position = 4)
    private String description;

    @NotNull
    @ApiModelProperty(value = "Course Thumbnail", example = "http://images.domain.com/thumbnail-1.jpg", position = 5)
    private String thumbUrl;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Course Register Date", example = "31-12-0000", dataType = "date-time", position = 6)
    private LocalDate registerDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Course Expiration Date", example = "31-12-0000", dataType = "date-time", position = 7)
    private LocalDate expirationDate;

    @ApiModelProperty(value = "Course Lessons", dataType = "List", position = 8)
    private List<Lesson> lessons;

    public CourseResponse(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.totalHours = entity.getTotalHours();
        this.isActive = entity.getIsActive();
        this.description = entity.getDescription();
        this.thumbUrl = entity.getThumbUrl();
        this.registerDate = entity.getRegisterDate();
        this.expirationDate = entity.getExpirationDate();
        this.lessons = new ArrayList<>(entity.getLessons());
    }
}
