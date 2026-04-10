package com.example.report_service.service;

import com.example.report_service.dao.ReportDao;
import com.example.report_service.model.Report;
import com.example.report_service.model.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    // Called by Quiz-service via Feign after scoring
    public ResponseEntity<String> saveReport(ReportDTO reportDTO) {
        Report report = new Report();
        report.setStudentName(reportDTO.getStudentName());
        report.setQuizId(reportDTO.getQuizId());
        report.setScore(reportDTO.getScore());
        reportDao.save(report);

        return new ResponseEntity<>("Report saved successfully", HttpStatus.CREATED);
    }

    // Get all reports for a student
    public ResponseEntity<List<Report>> getReportsByStudent(String studentName) {
        List<Report> reports = reportDao.findByStudentName(studentName);
        return ResponseEntity.ok(reports);
    }

    // Get all reports for a specific quiz
    public ResponseEntity<List<Report>> getReportsByQuiz(Integer quizId) {
        List<Report> reports = reportDao.findByQuizId(quizId);
        return ResponseEntity.ok(reports);
    }
}
