package com.vantagepoint.backend.infrastructure.user.adapter.in.web;



import com.vantagepoint.backend.application.user.service.UserApplicationService;
import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUserCommand command) {
        userApplicationService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

