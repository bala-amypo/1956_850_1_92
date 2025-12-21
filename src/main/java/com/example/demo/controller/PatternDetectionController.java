package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class PatternDetectionController {

    private final PatternDetectionService service;

    public PatternDetectionController(PatternDetectionService service) {
        this.service = service;
    }

    @PostMapping("/detect/{zoneId}")
    public PatternDetectionResult detect(@PathVariable long zoneId) {
        return service.detectPattern(zoneId);
    }

    @GetMapping("/zone/{zoneId}")
    public List<PatternDetectionResult> results(@PathVariable long zoneId) {
        return service.getResultsByZone(zoneId);
    }
}
