package com.example.sms.dto;

import com.example.sms.entity.Reports;
import com.example.sms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportResponse toResponse(Reports report){
        return new ReportResponse(
                report.getId(),
                report.getReportNumber(),
                report.getReportTime(),
                report.getTitle(),
                report.getDescription(),
                report.getOccurrenceDate(),
                report.getReporter().getFullName()
        );
    }
    public Reports toEntity(ReportCreateRequest request, User reporter){

        Reports report = new Reports();
        report.setTitle(request.title());
        report.setDescription(request.description());
        report.setOccurrenceDate(request.occurrenceDate());
        report.setReporter(reporter);
        return report;
    }

    public void updateEntityFromRequest(Reports report, ReportUpdateRequest updatedRequest){

        report.setTitle(updatedRequest.title());
        report.setDescription(updatedRequest.description());
        report.setOccurrenceDate(updatedRequest.occurrenceDate());
    }

}
