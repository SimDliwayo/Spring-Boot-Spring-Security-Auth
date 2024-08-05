package co.za.wethinkcode.wethinkcode.controller;


import co.za.wethinkcode.wethinkcode.AuthenticateRequest;
import co.za.wethinkcode.wethinkcode.AuthenticateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticateController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request) {
        // Now I am validating using the username and user password.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            if (authentication.isAuthenticated()) {
                String token = UUID.randomUUID().toString();
                return ResponseEntity.ok(new AuthenticateResponse(token));
            } else {
                return ResponseEntity.status(401).body("Authentication failed");
            }
    }
}
