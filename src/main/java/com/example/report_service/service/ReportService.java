package com.example.report_service.service;

import com.example.report_service.dao.ReportDao;
import com.example.report_service.feign.QuizInterface;
import com.example.report_service.model.Report;
import com.example.report_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    @Autowired
    QuizInterface quizInterface; // Using the name from the feign package

    @Autowired
    private RestTemplate restTemplate; // Or WebClient

    public void startProctoring(String studentName, Integer quizId) {
        String url = "http://localhost:8000/start-proctoring?studentName=" + studentName + "&quizId=" + quizId;
        restTemplate.postForEntity(url, null, String.class);
    }

    public void stopProctoring() {
        String url = "http://localhost:8000/stop-proctoring";
        restTemplate.postForEntity(url, null, String.class);
    }

    public ResponseEntity<String> submitQuiz(String studentName, Integer quizId, List<Response> responses) {
        // Call Question Service for score
        Integer score = quizInterface.getScore(responses).getBody();

        // Save result
        Report report = new Report();
        report.setStudentName(studentName);
        report.setQuizId(quizId);
        report.setScore(score);
        reportDao.save(report);

        return new ResponseEntity<>("Success! Score: " + score, HttpStatus.CREATED);
    }
}
