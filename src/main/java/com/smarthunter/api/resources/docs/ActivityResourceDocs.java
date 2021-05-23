package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.ActivityRequest;
import com.smarthunter.api.contracts.responses.ActivityResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Activities")
public interface ActivityResourceDocs {
    @ApiOperation(value = "List all activities")
    /*@ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue  = false,
    paramType = "header", example = "Bearer auusyfadguadsfgy23432")*/
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "activities found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "activities not found")
    })
    ResponseEntity<Page<ActivityResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a activity by id", response = ActivityResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "activity found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "activity not found")
    })
    ActivityResponse findById(@ApiParam(value = "Activity id", example = "0") Long id);


    @ApiOperation(value = "Create new Activity", response = ActivityResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "activity created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    ActivityResponse create(ActivityRequest activity);

    @ApiOperation(value = "updates an existing activity", response = ActivityResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "activity updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    ActivityResponse update(@ApiParam(value = "Activity id", example = "0") Long id, ActivityRequest activity);


    @ApiOperation(value = "Remove a existing activity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "activity removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "Activity id", example = "0") Long id);
}
