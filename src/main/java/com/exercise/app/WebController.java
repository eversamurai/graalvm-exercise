package com.exercise.app;

import com.exercise.app.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class WebController {
    @Autowired
    private ExecutorService executorService;
    @GetMapping("/")
    public String health(){
        return "Application running well";
    }

    @GetMapping("/id")
    public UUID executeCommand(){
        return executorService.executeCommand(null);
    }
}
