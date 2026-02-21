package com.vantagepoint.backend.infrastructure.user.adapter.in.web;



import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.in.CreateUserUseCase;
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

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO request) {
        // Creamos el comando (esto dispara las validaciones de nulos/vacíos)
        CreateUserCommand command = new CreateUserCommand(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

        User user = createUserUseCase.handle(command);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // DTO local para la petición web
    @lombok.Data
    public static class UserRequestDTO {
        private String username;
        private String email;
        private String password;
    }
}
