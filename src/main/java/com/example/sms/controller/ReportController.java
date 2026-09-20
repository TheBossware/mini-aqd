package com.example.sms.controller;


import com.example.sms.dto.ReportCreateRequest;
import com.example.sms.dto.ReportResponse;
import com.example.sms.dto.ReportUpdateRequest;
import com.example.sms.entity.Reports;
import com.example.sms.service.ReportService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // 201 Created
    public ReportResponse addReport(@RequestBody ReportCreateRequest request){
        return reportService.addReport(request);
    }

    @GetMapping
    public List<ReportResponse> getAllReports(){
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ReportResponse getById(@PathVariable Long id){
        return reportService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        reportService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ReportResponse updateReport(@PathVariable Long id, @RequestBody ReportUpdateRequest report){
        return reportService.updateReport(id, report);
    }

}
