package com.example.report_service.controller;

import com.example.report_service.model.Report;
import com.example.report_service.model.ReportDTO;
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

    // Called by Quiz-service via Feign to save a result
    @PostMapping("save")
    public ResponseEntity<String> saveReport(@RequestBody ReportDTO reportDTO) {
        return reportService.saveReport(reportDTO);
    }

    // Get all reports for a student
    @GetMapping("student/{studentName}")
    public ResponseEntity<List<Report>> getReportsByStudent(@PathVariable String studentName) {
        return reportService.getReportsByStudent(studentName);
    }

    // Get all reports for a quiz
    @GetMapping("quiz/{quizId}")
    public ResponseEntity<List<Report>> getReportsByQuiz(@PathVariable Integer quizId) {
        return reportService.getReportsByQuiz(quizId);
    }
}