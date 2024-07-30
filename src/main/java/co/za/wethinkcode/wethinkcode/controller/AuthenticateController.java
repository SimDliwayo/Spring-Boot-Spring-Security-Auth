package co.za.wethinkcode.wethinkcode.controller;


import co.za.wethinkcode.wethinkcode.AuthenticateRequest;
import co.za.wethinkcode.wethinkcode.AuthenticateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthenticateController {

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request) {
        // Validating, checking for emptiness
        if (request.getUsername() != null && !request.getUsername().isEmpty()
                && request.getPassword() != null && !request.getPassword().isEmpty()) {
            String token = UUID.randomUUID().toString(); // Generating a simple token

            return ResponseEntity.ok(new AuthenticateResponse(token));
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }

    }
}
