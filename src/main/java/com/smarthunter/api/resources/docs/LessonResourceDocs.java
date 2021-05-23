package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.LessonRequest;
import com.smarthunter.api.contracts.responses.LessonResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Lessons")
public interface LessonResourceDocs {
    @ApiOperation(value = "List all lessons")
    /*@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue  = false,
    paramType = "header", example = "Bearer auusyfadguadsfgy23432")*/
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lessons found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "lessons not found")
    })
    ResponseEntity<Page<LessonResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a lesson by id", response = LessonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lesson found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "lesson not found")
    })
    LessonResponse findById(@ApiParam(value = "Lesson id", example = "0") Long id);


    @ApiOperation(value = "Create new Lesson", response = LessonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "lesson created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    LessonResponse create(LessonRequest lesson);

    @ApiOperation(value = "updates an existing lesson", response = LessonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lesson updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    LessonResponse update(@ApiParam(value = "Lesson id", example = "0") Long id, LessonRequest lesson);


    @ApiOperation(value = "Remove a existing lesson")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lesson removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Lesson id", example = "0") Long id);
}
