package com.example.demo.controller;

import com.example.demo.services.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProcessController {

    @Autowired
    public Processor processor;

    @PostMapping
    public void map() throws IOException {
        this.processor.doProcessor();
    }
}
