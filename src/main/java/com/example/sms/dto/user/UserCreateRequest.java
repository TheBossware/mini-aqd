package com.example.sms.dto.user;

public record UserCreateRequest(
        String employeeId,
        String fullName,
        String department,
        String email,
        String role,
        String company
) {
}
