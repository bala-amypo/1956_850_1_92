package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private HotspotZone zone;

    private LocalDate analysisDate;
    private Integer crimeCount;
    private String detectedPattern;

    // getters & setters
}
