package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.EnrolledCourseRequest;
import com.smarthunter.api.contracts.responses.EnrolledCourseResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Enrolled Courses")
public interface EnrolledCourseResourceDocs {

    @ApiOperation(value = "List all enrolled courses")
    /*@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue  = false,
    paramType = "header", example = "Bearer auusyfadguadsfgy23432")*/
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "enrolled course found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "enrolled course not found")
    })
    ResponseEntity<Page<EnrolledCourseResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a enrolled course by id", response = EnrolledCourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "enrolled course found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "enrolled course not found")
    })
    EnrolledCourseResponse findById(@ApiParam(value = "Course id", example = "0") Long id);


    @ApiOperation(value = "Create new enrolled course", response = EnrolledCourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "enrolled course created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    EnrolledCourseResponse create(EnrolledCourseRequest course);

    @ApiOperation(value = "updates an existing enrolled course", response = EnrolledCourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "enrolled course updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    EnrolledCourseResponse update(@ApiParam(value = "Course id", example = "0") Long id, EnrolledCourseRequest course);

    @ApiOperation(value = "Remove a existing enrolled course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "enrolled course removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Course id", example = "0") Long id);
}
