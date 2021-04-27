package com.smarthunter.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.entities.Course;
import com.smarthunter.api.entities.Lesson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {
    private Long id;
    @ApiModelProperty(required = true,example = "Course name")
    private String name;
    @ApiModelProperty(required = true,example = "1",dataType = "integer")
    private Long totalHours;
    @ApiModelProperty(required = true,example = "true", dataType = "boolean")
    private Boolean isActive;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true,example = "31-12-0000",dataType = "date-time")
    private LocalDate registerDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(required = true,example = "31-12-0000",dataType = "date-time")
    private LocalDate expirationDate;
    @ApiModelProperty(dataType = "List")
    private List<Lesson> lessons;

    public CourseResponseDTO(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.totalHours = entity.getTotalHours();
        this.isActive = entity.getIsActive();
        this.registerDate = entity.getRegisterDate();
        this.expirationDate = entity.getExpirationDate();
        this.lessons = entity.getLessons();
    }
}
