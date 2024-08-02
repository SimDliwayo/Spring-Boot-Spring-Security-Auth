package co.za.wethinkcode.wethinkcode.controller;


import co.za.wethinkcode.wethinkcode.AuthenticateRequest;
import co.za.wethinkcode.wethinkcode.AuthenticateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request) {
        // Now I am validating using the username and user password.
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            if (authentication.isAuthenticated()) {
                String token = UUID.randomUUID().toString();
                return ResponseEntity.ok(new AuthenticateResponse(token));
            } else {
                return ResponseEntity.status(401).body("Authentication failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Authentication failed");
        }

        // Validating, checking for emptiness
//        if (request.getUsername() != null && !request.getUsername().isEmpty()
//                && request.getPassword() != null && !request.getPassword().isEmpty()) {
//            String token = UUID.randomUUID().toString(); // Generating a simple token
//
//            return ResponseEntity.ok(new AuthenticateResponse(token));
//        } else {
//            return ResponseEntity.badRequest().body("Invalid username or password");
//        }

    }
}
