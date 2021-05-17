package com.smarthunter.api.resources.docs;

import com.smarthunter.api.contracts.requests.UserRequest;
import com.smarthunter.api.contracts.responses.UserResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Users")
public interface UserResourceDocs {

    @ApiOperation(value = "List all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "users found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "users not found")
    })
    ResponseEntity<Page<UserResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Find a user by id", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "users found successfully"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 404, message = "users not found")
    })
    UserResponse findById(@ApiParam(value = "User id", example = "0") Long id);

    @ApiOperation(value = "Create a new user", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "user created successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    UserResponse create(UserRequest user);

    @ApiOperation(value = "Updates an existing user", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "user updated successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    UserResponse update(@ApiParam(value = "User id", example = "0") Long id, UserRequest user);

    @ApiOperation(value = "Remove a user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "user removed successfully"),
            @ApiResponse(code = 401, message = "not authorized")
    })
    void remove(@ApiParam(value = "User id", example = "0") Long id);
}
