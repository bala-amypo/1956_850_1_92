package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crimeType;
    private String description;
    private Double latitude;
    private Double longitude;
    private LocalDateTime occurredAt;

    // getters & setters
}
