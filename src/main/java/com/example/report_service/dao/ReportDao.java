package com.example.report_service.dao;

import com.example.report_service.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDao extends JpaRepository<Report, Integer> {
}
