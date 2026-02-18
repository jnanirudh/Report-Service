package com.example.report_service.controller;

import com.example.report_service.model.Response;
import com.example.report_service.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("submit")
    public ResponseEntity<String> submitQuiz(@RequestParam String studentName,
                                             @RequestParam Integer quizId,
                                             @RequestBody List<Response> responses) {
        return reportService.submitQuiz(studentName, quizId, responses);
    }
}