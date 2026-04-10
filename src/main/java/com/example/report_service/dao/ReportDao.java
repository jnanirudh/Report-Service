package com.example.report_service.dao;

import com.example.report_service.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao extends JpaRepository<Report, Integer> {

    // Get all reports for a student
    List<Report> findByStudentName(String studentName);

    // Get all reports for a specific quiz
    List<Report> findByQuizId(Integer quizId);
}
