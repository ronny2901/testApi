package com.testApi.api.controller;

import com.testApi.persistence.entity.UsersEntity;
import com.testApi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Tag(name ="GitHub", description = "Apis for Github integration")
public class UserController {
    final UserService userService;

    @Operation(summary = "Search Giithub profile by name and save on database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @GetMapping(path="/login")
    public ResponseEntity<UsersEntity> getUser(@RequestParam(value="login", required = true) final String login) {
        return ResponseEntity.ok().body(userService.findUserProfile(login));
    }
}
