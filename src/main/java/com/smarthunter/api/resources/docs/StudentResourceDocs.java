package com.smarthunter.api.resources.docs;

import com.smarthunter.api.dtos.StudentRequestDTO;
import com.smarthunter.api.dtos.StudentResponseDTO;
import com.smarthunter.api.entities.EnrolledCourse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Students")
public interface StudentResourceDocs {
    @ApiOperation(value="List all students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "students found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "students not found")
    })
    ResponseEntity<List<StudentResponseDTO>> findAll();

    @ApiOperation(value = "Find a student by id",response = StudentResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "students found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "students not found")
    })
    StudentResponseDTO findById(@ApiParam(value = "Student id",example = "0")Long id);

    @ApiOperation(value = "Create a new student",response = StudentResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "student created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    StudentResponseDTO create(StudentRequestDTO student);

    @ApiOperation(value = "Updates an existing student",response = StudentResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "course updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    StudentResponseDTO update(@ApiParam(value = "Student id",example = "0") Long id,StudentRequestDTO student);

    @ApiOperation(value = "Add a enrolled course by id",response = StudentResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "enrolled course created successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "students not found")
    })
    StudentResponseDTO newEnrolledCourse(@ApiParam(value = "Student id",example = "0") Long id,EnrolledCourse enrolledCourse);

    @ApiOperation(value = "Remove a student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "student removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Student id",example = "0") Long id);
}
