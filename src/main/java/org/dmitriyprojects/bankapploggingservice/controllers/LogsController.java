package org.dmitriyprojects.bankapploggingservice.controllers;

import org.dmitriyprojects.bankapploggingservice.db.LogDocument;
import org.dmitriyprojects.bankapploggingservice.db.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogsController {
    @Autowired
    LoggingService loggingService;

    @GetMapping("/getLogs")
    public List<LogDocument> documents(@RequestParam(name = "page") String page) {
        return loggingService.getLogDocumentByPage(page).getContent();
    }
}
