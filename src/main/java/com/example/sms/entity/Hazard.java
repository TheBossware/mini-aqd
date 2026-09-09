package com.example.sms.entity;

import com.example.sms.entity.enums.HazardCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sms_hazard")

public class Hazard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hazard_number", nullable = false, length = 50)
    private String hazardNumber;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "identified_date", nullable = false)
    private LocalDateTime identifiedDate;

    @Column(name = "entered_by", nullable = false, length = 100)
    private String enteredBy;

    @Column(name = "sta")

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "hazard_category", nullable = false, length = 50)
    private HazardCategory category;

// add department as enum
}
