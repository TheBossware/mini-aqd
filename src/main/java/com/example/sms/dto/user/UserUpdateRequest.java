package com.example.sms.dto.user;

public record UserUpdateRequest(
        String fullName,
        String department,
        String email,
        String role,
        String company
) {
}
