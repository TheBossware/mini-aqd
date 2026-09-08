package com.example.sms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sms_user")

public class User {

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", length = 50, unique = true)
    private String employeeId; //sıcıl no

    @Column(name = "user_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "department", length = 50, nullable = false)
    private String department;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "role", length = 100, nullable = false)
    private String role;

    @Column(name = "is_active", nullable = false)
    private Boolean active = true;
    //default active

    @Column(name = "company", length = 100, nullable = false)
    private String company;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}










