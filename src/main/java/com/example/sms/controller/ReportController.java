package com.example.sms.controller;


import com.example.sms.entity.Reports;
import com.example.sms.service.ReportService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }



    @PostMapping
    public Reports addReport(@RequestBody Reports report){
        return reportService.addReport(report);
    }

    @GetMapping
    public List<Reports> getAllReports(){
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Reports getById(@PathVariable Long id){
        return reportService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        reportService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Reports updateReport(@PathVariable Long id, @RequestBody Reports report){
        return reportService.updateReport(id, report);
    }

}
