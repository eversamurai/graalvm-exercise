package com.exercise.app.service;


import com.exercise.app.executable.Command;
import com.exercise.app.model.ExcutableRequest;
import com.exercise.app.storage.CommandHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ExecutorService {

    Logger log = LoggerFactory.getLogger(ExecutorService.class);
    private final CommandHolder holder;
    private final Command  command;
    private final TemplateBuilder builder;

    public ExecutorService(CommandHolder holder, Command command, TemplateBuilder builder){
        this.holder = holder;
        this.command = command;
        this.builder = builder;
    }

    public UUID executeCommand(ExcutableRequest excutableRequest){
        log.info("Generating random UID");
        return UUID.randomUUID();
    }

    public String renderLetter(String name, String city){
        Map<String, String> params = new HashMap<>();
        params.put("name",name);
        params.put("city",city);

         builder.getLetter(params);
         return "Letter generated";
    }
}
