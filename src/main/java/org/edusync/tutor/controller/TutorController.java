package org.edusync.tutor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
