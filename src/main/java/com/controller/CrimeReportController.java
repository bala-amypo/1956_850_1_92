package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crime-reports")
public class CrimeReportController {

    private final CrimeReportService crimeReportService;

    public CrimeReportController(CrimeReportService crimeReportService) {
        this.crimeReportService = crimeReportService;
    }

    @PostMapping
    public CrimeReport create(@RequestBody CrimeReport report) {
        return crimeReportService.save(report);
    }

    @GetMapping
    public List<CrimeReport> getAll() {
        return crimeReportService.getAll();
    }
}
