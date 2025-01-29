package org.edusync.tutor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TutorController {
    @GetMapping(path="/hello")
    public String hello() {
        return "<html><body><h1>Hello World</h1></body></html>";
    }

    @GetMapping(path="/echo/{message}")
    public String echo(
            @PathVariable String message
    ) {
        System.out.println(message + message);
        return message;
    }
    // address: http://localhost:8080/api/book?vocab_mean=10&pages=20
    @GetMapping(path="/book")
    public ResponseEntity<String> queryParam(
            @RequestParam int vocab_mean,
            @RequestParam int pages
    ){
        System.out.println(vocab_mean);
        System.out.println(pages);
        System.out.println(vocab_mean + pages);
        System.out.println(vocab_mean * pages);
        int summation = vocab_mean + pages;
        int multiply = vocab_mean * pages;
        String result = "Summation: " + summation + ", Multiply: " + multiply;
        return ResponseEntity.ok(result);
    }
}
