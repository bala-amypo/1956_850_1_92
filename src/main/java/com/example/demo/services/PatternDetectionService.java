package com.example.demo.service;

import com.example.demo.model.PatternDetectionResult;
import java.util.List;

public interface PatternDetectionService {
    PatternDetectionResult detectPattern(long zoneId);
    List<PatternDetectionResult> getResultsByZone(long zoneId);
}
