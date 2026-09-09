package com.example.sms.dto;

import java.time.LocalDateTime;

public record ReportResponse(
        Long id,
        String reportNumber,
        LocalDateTime reportTime,
        String title,
        String description,
        LocalDateTime occurrenceDate,
        String reporterName) {
}
