package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "zoneName"))
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private Double centerLat;
    private Double centerLong;
    private String severityLevel; // LOW / MEDIUM / HIGH

    // getters & setters
}
