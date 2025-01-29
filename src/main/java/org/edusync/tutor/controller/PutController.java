package org.edusync.tutor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.edusync.tutor.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutController {
    
    private static final Logger logger = LoggerFactory.getLogger(PutController.class);

    @PutMapping("/user/{userId}")
    public ResponseEntity<UserRequest> updateUser(
            @PathVariable Long userId,
            @RequestBody UserRequest request
    ) {
        logger.info("User ID: {}", userId);
        logger.info("Username: {}", request.getUsername());
        logger.info("Phone Number: {}", request.getPhoneNumber());
        logger.info("Email: {}", request.getEmail());
        logger.info("Is Korean: {}", request.getIsKorean());

        return ResponseEntity.ok(request);
    }
} 