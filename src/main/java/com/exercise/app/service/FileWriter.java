package com.exercise.app.service;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
public class FileWriter {

    public OutputStream getOutputStream(String fileName) throws FileNotFoundException {
        return new FileOutputStream(fileName);
    }

    public BufferedWriter getOutputWriter(String filename) {return null;}
}
