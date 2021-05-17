package com.smarthunter.api.contracts.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.contracts.summaries.CourseSummary;
import com.smarthunter.api.contracts.summaries.UserSummary;
import com.smarthunter.api.entities.EnrolledCourse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnrolledCourseResponse {

    @ApiModelProperty(value = "Enrolled Course ID", example = "1", dataType = "integer")
    private Long id;

    @ApiModelProperty(value = "Course ID", example = "1", dataType = "integer", position = 1)
    private CourseSummary course;

    @ApiModelProperty(value = "User ID", example = "1", dataType = "integer", position = 2)
    private UserSummary user;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Enrolled Date", example = "31-12-0000", dataType = "date-time", position = 3)
    private LocalDate registerDate;

    public EnrolledCourseResponse(EnrolledCourse entity) {
        this.id = entity.getId();
        this.course = new CourseSummary(entity.getCourse().getId());
        this.user = new UserSummary(entity.getUser().getId());
        this.registerDate = entity.getRegisterDate();
    }
}
