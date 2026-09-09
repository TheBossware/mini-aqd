package com.example.sms.dto;

import java.time.LocalDateTime;

public record ReportUpdateRequest(
        String title,
        String description,
        LocalDateTime  occurrenceDate) {
}
