package com.example.sms.dto;

import java.time.LocalDateTime;

public record ReportCreateRequest(
                                 String title,
                                 String description,
                                 LocalDateTime occurrenceDate,
                                 Long reporterId ) {}



