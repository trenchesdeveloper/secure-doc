package com.trenchesdeveloper.shielddoc.controller;

import com.trenchesdeveloper.shielddoc.dtoRequest.UserRequest;
import com.trenchesdeveloper.shielddoc.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRequest user) {
        // For demonstration purposes, we simply return the received user object.
        // In a real application, you would save the user to the database here.
        return ResponseEntity.ok(user);
    }

    @GetMapping("/verify/account")
    public ResponseEntity<String> verifyAccount(@RequestParam("token") String token) {
        // For demonstration purposes, we simply return a success message.
        // In a real application, you would verify the token here.
        return ResponseEntity.ok("Account verified successfully with token: " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // For demonstration purposes, we simply return the received user object.
        // In a real application, you would authenticate the user here.
        return ResponseEntity.ok(user);
    }
}
