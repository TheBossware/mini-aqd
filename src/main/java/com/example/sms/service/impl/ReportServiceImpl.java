package com.example.sms.service.impl;

import com.example.sms.dto.ReportCreateRequest;
import com.example.sms.dto.ReportMapper;
import com.example.sms.dto.ReportResponse;
import com.example.sms.dto.ReportUpdateRequest;
import com.example.sms.entity.Reports;
import com.example.sms.entity.User;
import com.example.sms.repository.ReportRepository;
import com.example.sms.repository.UserRepository;
import com.example.sms.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final UserRepository userRepository;

    public ReportServiceImpl(ReportRepository reportRepository, ReportMapper reportMapper, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
        this.userRepository = userRepository;
    }



    @Override
    public ReportResponse addReport(ReportCreateRequest request) {
        User reporter = userRepository.findById(request.reporterId()) .orElseThrow(() -> new RuntimeException("User not found: " + request.reporterId()));
        Reports report = reportMapper.toEntity(request, reporter);
        report.setReportTime(LocalDateTime.now());
        String uniqueCode = UUID.randomUUID().toString();

        Reports savedReport = reportRepository.save(report);
        ReportResponse reportResponse = reportMapper.toResponse(savedReport);
        return reportResponse;
    }

    @Override
    public List<ReportResponse> getAllReports()
    {

    }

    @Override
    public ReportResponse getById(Long id) {
        Reports report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report does not exists: " + id));
        return reportMapper.toResponse(report);
    }

    @Override
    public void deleteById(Long id) {
        Reports report = getById(id);  //first find the report
        reportRepository.delete(report);
    }

    @Override
    public ReportResponse updateReport(Long id, ReportUpdateRequest request) {
        Reports existingReport =  reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report does not exists: " + id));
        reportMapper.updateEntityFromRequest(existingReport, request);
        Reports savedReport = reportRepository.save(existingReport);
        return reportMapper.toResponse(savedReport);
    }
}






