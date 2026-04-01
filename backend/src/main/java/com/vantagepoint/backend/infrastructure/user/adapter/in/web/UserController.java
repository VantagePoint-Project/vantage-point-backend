package com.vantagepoint.backend.infrastructure.user.adapter.in.web;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.application.user.dto.UserResponse;
import com.vantagepoint.backend.application.user.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserCommand command) {

        UserResponse response = userApplicationService.execute(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
