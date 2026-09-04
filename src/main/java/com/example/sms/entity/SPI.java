package com.example.sms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

@Getter
@Setter
@Entity
@Table(name = "spi")
public class SPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spi_code", nullable = false, unique = true, length = 30)
    private String code;

    @Column(name = "spi_name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "operational_area", nullable = false, length = 20)
    private String operationalArea;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active")
    private Boolean active = true;
}
