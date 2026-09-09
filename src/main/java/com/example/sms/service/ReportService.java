package com.example.sms.service;

import com.example.sms.dto.ReportCreateRequest;
import com.example.sms.dto.ReportResponse;
import com.example.sms.dto.ReportUpdateRequest;
import com.example.sms.entity.Reports;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReportService {
    ReportResponse addReport(ReportCreateRequest report);
    List<ReportResponse> getAllReports();
    ReportResponse getById(Long id);
    void deleteById(Long id);
    ReportResponse updateReport(Long id, ReportUpdateRequest reports);
}







