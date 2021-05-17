package com.smarthunter.api.contracts.requests;

import com.smarthunter.api.contracts.summaries.CourseSummary;
import com.smarthunter.api.contracts.summaries.UserSummary;
import com.smarthunter.api.entities.EnrolledCourse;
import com.smarthunter.api.utils.Convertible;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnrolledCourseRequest implements Convertible<EnrolledCourse> {

    @NotNull
    @ApiModelProperty(value = "Course ID", required = true)
    private CourseSummary course;

    @NotNull
    @ApiModelProperty(value = "User ID", required = true, position = 1)
    private UserSummary user;

    @Override
    public EnrolledCourse convert() {
        return new EnrolledCourse(this);
    }
}
