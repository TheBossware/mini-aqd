package com.example.sms.service.impl;

import com.example.sms.entity.Reports;
import com.example.sms.repository.ReportRepository;
import com.example.sms.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Reports addReport(Reports report) {
        report.setReportTime(LocalDateTime.now());
        String uniqueCode = UUID.randomUUID().toString().substring(0,8).toUpperCase();
        report.setReportNumber(uniqueCode);
        return reportRepository.save(report);

    }
    @Override
    public List<Reports> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public Reports getById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report does not exists: " + id));
    }

    @Override
    public void deleteById(Long id) {
        Reports report = getById(id);  //first find the report
        reportRepository.delete(report);
    }

    @Override
    public Reports updateReport(Long id, Reports updatedReport) {
        Reports existingReport = getById(id);
        existingReport.setTitle(updatedReport.getTitle());
        existingReport.setDescription(updatedReport.getDescription());
        existingReport.setOccurrenceDate(updatedReport.getOccurrenceDate());
        return reportRepository.save(existingReport);
    }
}






