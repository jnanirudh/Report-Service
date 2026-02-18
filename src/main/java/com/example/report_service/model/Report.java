package com.example.report_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quizId;
    private String studentName;
    private Integer score;
}