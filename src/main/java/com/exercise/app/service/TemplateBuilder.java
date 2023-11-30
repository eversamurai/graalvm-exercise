package com.exercise.app.service;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.Map;

@Component
public class TemplateBuilder {

    private static final Logger log = LoggerFactory.getLogger(TemplateBuilder.class);
    private static final String TEMPLATE_NAME = "NameLetter.twig";
    private final String templatePath;
    private FileWriter writer;

    public TemplateBuilder(@Value("${template.path}") String templatePath, FileWriter writer) {
        this.templatePath = templatePath;
        this.writer = writer;
    }

    public void getLetter(Map<String, String> params) {

        JtwigModel model = JtwigModel.newModel();

        params.forEach((key, value) -> {
            log.info("Received param: [{}] value: [{}])", key, value);
            model.with(key, value);
        });
        log.info("Rendering template: path: [{}], name:[{}]",templatePath,TEMPLATE_NAME);
        JtwigTemplate template = JtwigTemplate.classpathTemplate(templatePath + TEMPLATE_NAME);
        try(OutputStream stream = writer.getOutputStream(".junk/JunkLetter.txt")){
            template.render(model,stream);
        } catch (Exception e){
            log.error("Something went wrong on render [{}]",
                    e.getCause().getMessage());
        }

    }
}
