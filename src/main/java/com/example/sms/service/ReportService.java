package com.example.sms.service;

import com.example.sms.entity.Reports;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReportService {
    public Reports addReport(Reports report);
    public List<Reports> getAllReports();
    public Reports getById(Long id);
    public void deleteById(Long id);
    public Reports updateReport(Long id, Reports reports);
}







