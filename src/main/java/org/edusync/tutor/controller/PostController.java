package org.edusync.tutor.controller;

import org.edusync.tutor.dto.BookRequest;
import org.edusync.tutor.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("/post")
    public ResponseEntity<BookRequest> createBook(
            @RequestParam(required = false) String param1,
            @RequestBody BookRequest bookRequest
    ) {
        System.out.println("Received book: " + bookRequest.getName());
        System.out.println("Query parameter: " + param1);

        return ResponseEntity.ok(bookRequest);
    }

    @PostMapping("/user")
    public ResponseEntity<UserRequest> createUser(
            @RequestBody UserRequest userRequest
    ) {
        System.out.println("Received user information:");
        System.out.println("Username: " + userRequest.getUsername());
        System.out.println("Phone: " + userRequest.getPhoneNumber());
        System.out.println("Email: " + userRequest.getEmail());
        return ResponseEntity.ok(userRequest);
    }
} 