package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import com.example.demo.service.AnalysisLogService;

import java.time.LocalDate;
import java.util.List;

public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository crimeRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogService logService;

    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepo,
            CrimeReportRepository crimeRepo,
            PatternDetectionResultRepository resultRepo,
            AnalysisLogService logService) {
        this.zoneRepo = zoneRepo;
        this.crimeRepo = crimeRepo;
        this.resultRepo = resultRepo;
        this.logService = logService;
    }

    @Override
    public PatternDetectionResult detectPattern(long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("zone not found"));

        List<CrimeReport> crimes = crimeRepo
                .findByLatitudeBetweenAndLongitudeBetween(
                        zone.getCenterLat() - 0.1,
                        zone.getCenterLat() + 0.1,
                        zone.getCenterLong() - 0.1,
                        zone.getCenterLong() + 0.1
                );

        int count = crimes.size();
        String pattern = count > 5 ? "High"
                : count > 2 ? "Medium" : "No";

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setAnalysisDate(LocalDate.now());
        result.setCrimeCount(count);
        result.setDetectedPattern(pattern);

        logService.addLog(zoneId, "Pattern detected: " + pattern);
        return resultRepo.save(result);
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
