package com.example.sms.entity;

import com.example.sms.entity.enums.OccurrenceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sms_occurrence")

public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "occurrence_number", nullable = false, unique = true, length = 50)
    private String occurrenceNumber;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "occurrence_date", nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spi_id")
    private SPI spi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_investigator_id")
    private User assignedInvestigator;

    @Enumerated(EnumType.STRING)
    @Column(name = "occurrence_status", nullable = false, length = 50)
    private OccurrenceStatus status = OccurrenceStatus.OPEN;

}
