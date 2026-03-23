package com.vantagepoint.backend.infrastructure.user.adapter.in.web;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.application.user.service.UserApplicationService;
import com.vantagepoint.backend.infrastructure.user.adapter.in.web.dto.CreateUserRequest; // Import nuevo
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
    public ResponseEntity<Void> create(@RequestBody CreateUserRequest request) {
        // Mapeamos el DTO al Command (estilo Task)
        CreateUserCommand command = new CreateUserCommand(
                request.username(),
                request.email(),
                request.password()
        );

        userApplicationService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
