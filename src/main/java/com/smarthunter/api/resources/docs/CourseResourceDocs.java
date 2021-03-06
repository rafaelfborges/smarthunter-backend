package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.CourseRequest;
import com.smarthunter.api.contracts.responses.CourseResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Courses")
public interface CourseResourceDocs {
    @ApiOperation(value = "List all courses")
    /*@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue  = false,
    paramType = "header", example = "Bearer auusyfadguadsfgy23432")*/
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "courses found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "courses not found")
    })
    ResponseEntity<Page<CourseResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a course by id", response = CourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "course found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "course not found")
    })
    CourseResponse findById(@ApiParam(value = "Course id", example = "0") Long id);


    @ApiOperation(value = "Create new Course", response = CourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "course created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    CourseResponse create(CourseRequest course);

    @ApiOperation(value = "updates an existing course", response = CourseResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "course updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    CourseResponse update(@ApiParam(value = "Course id", example = "0") Long id, CourseRequest course);


    @ApiOperation(value = "Remove a existing course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "course removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Course id", example = "0") Long id);
}
