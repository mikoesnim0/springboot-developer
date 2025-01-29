package org.edusync.tutor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {
    
    @GetMapping("/hello")
    public String hello() {
        return "<html><body><h1>Hello World</h1></body></html>";
    }

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        System.out.println(message + message);
        return message;
    }

    @GetMapping("/book")
    public ResponseEntity<String> queryParam(
            @RequestParam int vocab_mean,
            @RequestParam int pages
    ){
        System.out.println(vocab_mean);
        System.out.println(pages);
        
        int summation = vocab_mean + pages;
        int multiply = vocab_mean * pages;
        
        String result = "Summation: " + summation + ", Multiply: " + multiply;
        return ResponseEntity.ok(result);
    }
} 