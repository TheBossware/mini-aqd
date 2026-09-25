package com.example.sms.dto.user;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String employeeId,
        String fullName,
        String department,
        String email,
        String role,
        Boolean active,
        String company,
        LocalDateTime createdAt
) {
}
