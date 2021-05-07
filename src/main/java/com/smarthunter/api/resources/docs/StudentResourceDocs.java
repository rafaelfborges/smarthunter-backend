package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.EnrolledCourseRequest;
import com.smarthunter.api.contracts.requests.StudentRequest;
import com.smarthunter.api.contracts.responses.StudentResponse;
import com.smarthunter.api.entities.EnrolledCourse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Students")
public interface StudentResourceDocs {
    @ApiOperation(value = "List all students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "students found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "students not found")
    })
    ResponseEntity<Page<StudentResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a student by id", response = StudentResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "students found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "students not found")
    })
    StudentResponse findById(@ApiParam(value = "Student id", example = "0") Long id);

    @ApiOperation(value = "Create a new student", response = StudentResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "student created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    StudentResponse create(StudentRequest student);

    @ApiOperation(value = "Updates an existing student", response = StudentResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "course updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    StudentResponse update(@ApiParam(value = "Student id", example = "0") Long id, StudentRequest student);

    @ApiOperation(value = "Remove a student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "student removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Student id", example = "0") Long id);
}
